package com.example.petdoctor.service.impl;

import com.example.petdoctor.pojo.Medicine;
import com.example.petdoctor.mapper.MedicineMapper;
import com.example.petdoctor.service.IMedicineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 药品表，存储平台提供的药品信息 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Service
public class MedicineServiceImpl extends ServiceImpl<MedicineMapper, Medicine> implements IMedicineService {

}
