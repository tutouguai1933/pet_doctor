package com.example.petdoctor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.petdoctor.pojo.Consultation;
import com.example.petdoctor.pojo.ConsultationMessage;
import com.example.petdoctor.mapper.ConsultationMapper;
import com.example.petdoctor.service.IConsultationMessageService;
import com.example.petdoctor.service.IConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
/**
 * <p>
 * 问诊记录表，存储用户与医生的问诊详情 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Service
public class ConsultationServiceImpl extends ServiceImpl<ConsultationMapper, Consultation> implements IConsultationService {

    @Autowired
    private IConsultationMessageService consultationMessageService;

    @Override
    public Consultation startConsultation(Long userId, Long doctorId, Long petId, String consultationType, String description) {
        // 创建新问诊记录
        Consultation consultation = new Consultation();
        consultation.setUserId(userId);
        consultation.setDoctorId(doctorId);
        consultation.setPetId(petId);
        consultation.setConsultationType(consultationType);
        consultation.setDescription(description);
        consultation.setStatus("未处理");  // 设置初始状态为未处理
        consultation.setConsultationDate(LocalDateTime.now());  // 设置当前时间为问诊创建时间

        // 保存问诊记录
        this.save(consultation);
        return consultation;
    }

    @Override
    public void sendMessage(Long consultationId, String sender, String messageType, String content, String voiceUrl) {
        // 创建新消息
        ConsultationMessage message = new ConsultationMessage();
        message.setConsultationId(consultationId);
        message.setSender(sender);
        message.setMessageType(messageType);
        if ("text".equals(messageType)) {
            message.setMessageContent(content);
        } else if ("voice".equals(messageType)) {
            message.setVoiceUrl(voiceUrl);
        }
        message.setSendTime(LocalDateTime.now());

        // 保存消息
        consultationMessageService.save(message);

        // 更新问诊的最后消息时间
        Consultation consultation = this.getById(consultationId);
        consultation.setLastMessageDate(LocalDateTime.now());
        this.updateById(consultation);
    }

    @Override
    public List<ConsultationMessage> getMessagesByConsultationId(Long consultationId) {
        // 使用 QueryWrapper 获取该问诊的所有消息
        return consultationMessageService.list(new QueryWrapper<ConsultationMessage>().eq("consultation_id", consultationId));
    }
}
