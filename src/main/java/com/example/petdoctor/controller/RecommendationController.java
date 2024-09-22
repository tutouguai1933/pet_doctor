package com.example.petdoctor.controller;

import com.example.petdoctor.pojo.Medicine;
import com.example.petdoctor.pojo.Symptom;
import com.example.petdoctor.service.IRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private IRecommendationService recommendationService;

    // 根据症状推荐药品
    @GetMapping("/medicines/{symptomId}")
    public List<Medicine> recommendMedicines(@PathVariable Long symptomId) {
        return recommendationService.recommendMedicinesBySymptom(symptomId);
    }

    // 根据症状推荐医生
    @GetMapping("/doctors/{symptomId}")
    public List<String> recommendDoctors(@PathVariable Long symptomId) {
        return recommendationService.recommendDoctorsBySymptom(symptomId);
    }

    // 获取热门症状
    @GetMapping("/hot/symptoms")
    public List<Symptom> getHotSymptoms() {
        return recommendationService.getHotSymptoms();
    }

    // 获取热门药品
    @GetMapping("/hot/medicines")
    public List<Medicine> getHotMedicines() {
        return recommendationService.getHotMedicines();
    }
}
