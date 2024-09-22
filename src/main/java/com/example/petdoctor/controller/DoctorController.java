package com.example.petdoctor.controller;

import com.example.petdoctor.pojo.Doctor;
import com.example.petdoctor.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * <p>
 * 医生表，存储医生的基本信息和资质 前端控制器
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private IDoctorService doctorService;

    // 添加医生
    @PostMapping("/add")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        doctorService.save(doctor);
        return doctor;
    }

    // 根据执业编号查找医生
    @GetMapping("/license/{licenseNumber}")
    public Doctor findByLicenseNumber(@PathVariable String licenseNumber) {
        Doctor doctor = doctorService.findByLicenseNumber(licenseNumber);
        if (doctor == null) {
            throw new RuntimeException("未找到对应执业编号的医生");
        }
        return doctor;
    }

    // 查询所有医生
    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return doctorService.list(); // 使用 MyBatis-Plus 提供的 list() 方法
    }

    // 根据ID查找医生
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getById(id);
        if (doctor == null) {
            throw new RuntimeException("医生未找到");
        }
        return doctor;
    }

    // 更新医生信息
    @PutMapping("/update")
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        doctorService.updateById(doctor);
        return doctor;
    }

    // 删除医生
    @DeleteMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        boolean result = doctorService.removeById(id);
        if (result) {
            return "医生删除成功";
        } else {
            throw new RuntimeException("删除失败，医生ID不存在");
        }
    }
}
