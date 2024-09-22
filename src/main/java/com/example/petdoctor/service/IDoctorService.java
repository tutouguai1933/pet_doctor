package com.example.petdoctor.service;

import com.example.petdoctor.pojo.Doctor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 医生表，存储医生的基本信息和资质 服务类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
public interface IDoctorService extends IService<Doctor> {
    // 根据执业编号查找医生
    Doctor findByLicenseNumber(String licenseNumber);
}
