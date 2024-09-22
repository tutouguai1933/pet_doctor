package com.example.petdoctor.mapper;

import com.example.petdoctor.pojo.Medicine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 药品表，存储平台提供的药品信息 Mapper 接口
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Mapper
public interface MedicineMapper extends BaseMapper<Medicine> {

    @Select("SELECT m.* FROM medicine m INNER JOIN medicine_symptom ms ON m.id = ms.medicine_id WHERE ms.symptom_id = #{symptomId}")
    List<Medicine> selectMedicinesBySymptomId(Long symptomId);
}
