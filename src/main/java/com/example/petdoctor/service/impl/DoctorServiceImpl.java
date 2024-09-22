package com.example.petdoctor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.petdoctor.pojo.Doctor;
import com.example.petdoctor.mapper.DoctorMapper;
import com.example.petdoctor.service.IDoctorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 医生表，存储医生的基本信息和资质 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements IDoctorService {
    @Override
    public Doctor findByLicenseNumber(String licenseNumber) {
        // 使用 QueryWrapper 根据执业编号查询医生
        return this.getOne(new QueryWrapper<Doctor>().eq("license_number", licenseNumber));
    }
}
