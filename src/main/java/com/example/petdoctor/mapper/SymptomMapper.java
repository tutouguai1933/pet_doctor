package com.example.petdoctor.mapper;

import com.example.petdoctor.pojo.Symptom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 症状表，存储不同种类宠物的常见症状及相关建议 Mapper 接口
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Mapper
public interface SymptomMapper extends BaseMapper<Symptom> {

}
