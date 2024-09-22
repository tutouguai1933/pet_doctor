package com.example.petdoctor.service.impl;

import com.example.petdoctor.pojo.Prescription;
import com.example.petdoctor.mapper.PrescriptionMapper;
import com.example.petdoctor.service.IPrescriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 处方表，存储医生为用户开具的处方 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Service
public class PrescriptionServiceImpl extends ServiceImpl<PrescriptionMapper, Prescription> implements IPrescriptionService {

}
