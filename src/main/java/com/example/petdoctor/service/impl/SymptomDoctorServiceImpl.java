package com.example.petdoctor.service.impl;

import com.example.petdoctor.pojo.SymptomDoctor;
import com.example.petdoctor.mapper.SymptomDoctorMapper;
import com.example.petdoctor.service.ISymptomDoctorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 症状与医生的推荐表，记录某症状推荐的医生及其推荐级别 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Service
public class SymptomDoctorServiceImpl extends ServiceImpl<SymptomDoctorMapper, SymptomDoctor> implements ISymptomDoctorService {

}
