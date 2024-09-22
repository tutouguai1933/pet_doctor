package com.example.petdoctor.service.impl;

import com.example.petdoctor.pojo.MedicineSymptom;
import com.example.petdoctor.mapper.MedicineSymptomMapper;
import com.example.petdoctor.service.IMedicineSymptomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 药品与症状关联表，存储能够缓解某些症状的药品信息 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Service
public class MedicineSymptomServiceImpl extends ServiceImpl<MedicineSymptomMapper, MedicineSymptom> implements IMedicineSymptomService {

}
