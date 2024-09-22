package com.example.petdoctor.service.impl;

import com.example.petdoctor.pojo.Symptom;
import com.example.petdoctor.mapper.SymptomMapper;
import com.example.petdoctor.service.ISymptomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 症状表，存储不同种类宠物的常见症状及相关建议 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Service
public class SymptomServiceImpl extends ServiceImpl<SymptomMapper, Symptom> implements ISymptomService {

}
