package com.example.petdoctor.service.impl;

import com.example.petdoctor.pojo.PrescriptionMedicine;
import com.example.petdoctor.mapper.PrescriptionMedicineMapper;
import com.example.petdoctor.service.IPrescriptionMedicineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 处方与药品的关联表，记录每张处方中的药品信息 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Service
public class PrescriptionMedicineServiceImpl extends ServiceImpl<PrescriptionMedicineMapper, PrescriptionMedicine> implements IPrescriptionMedicineService {

}
