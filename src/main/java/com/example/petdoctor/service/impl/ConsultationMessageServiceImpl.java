package com.example.petdoctor.service.impl;

import com.example.petdoctor.pojo.ConsultationMessage;
import com.example.petdoctor.mapper.ConsultationMessageMapper;
import com.example.petdoctor.service.IConsultationMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 诊室记录表，存储用户与医生的每次问诊记录，包括诊断和治疗方案 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */

@Service
public class ConsultationMessageServiceImpl extends ServiceImpl<ConsultationMessageMapper, ConsultationMessage> implements IConsultationMessageService {

    @Override
    public void saveMessage(ConsultationMessage message) {
        // 使用 MyBatis-Plus 提供的 save 方法保存消息
        this.save(message);
    }
}
