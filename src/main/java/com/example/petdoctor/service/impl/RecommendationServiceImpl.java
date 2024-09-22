package com.example.petdoctor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.petdoctor.pojo.Medicine;
import com.example.petdoctor.pojo.Symptom;
import com.example.petdoctor.mapper.MedicineMapper;
import com.example.petdoctor.mapper.SymptomMapper;
import com.example.petdoctor.service.IRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RecommendationServiceImpl implements IRecommendationService {

    @Autowired
    private MedicineMapper medicineMapper;

    @Autowired
    private SymptomMapper symptomMapper;

    @Override
    public List<Medicine> recommendMedicinesBySymptom(Long symptomId) {
        // 根据症状ID推荐药品，假设medicine_symptom表存在对应关系
        return medicineMapper.selectMedicinesBySymptomId(symptomId);
    }

    @Override
    public List<String> recommendDoctorsBySymptom(Long symptomId) {
        // 假设有方法推荐医生的名称
        return Arrays.asList("Dr. Smith", "Dr. Zhang", "Dr. Lee");
    }

    @Override
    public List<Symptom> getHotSymptoms() {
        // 查询热门症状（这里假设热门症状的定义为最近较多用户提及）
        QueryWrapper<Symptom> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("popularity");
        return symptomMapper.selectList(queryWrapper);
    }

    @Override
    public List<Medicine> getHotMedicines() {
        // 查询热门药品（假设热门药品是根据销量等属性定义的）
        QueryWrapper<Medicine> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("sales_volume");
        return medicineMapper.selectList(queryWrapper);
    }
}
