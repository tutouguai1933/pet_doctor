package com.example.petdoctor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.petdoctor.pojo.Medicine;
import com.example.petdoctor.pojo.Recommendedproduct;
import com.example.petdoctor.pojo.Symptom;

import java.util.List;

/**
 * <p>
 * 推荐商品表，存储系统推荐给用户的商品信息 服务类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
public interface IRecommendationService {
    // 根据症状推荐药品
    List<Medicine> recommendMedicinesBySymptom(Long symptomId);

    // 根据症状推荐医生
    List<String> recommendDoctorsBySymptom(Long symptomId);

    // 获取热门症状
    List<Symptom> getHotSymptoms();

    // 获取热门药品
    List<Medicine> getHotMedicines();
}
