package com.example.petdoctor.service;

import com.example.petdoctor.pojo.Consultation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.petdoctor.pojo.ConsultationMessage;

import java.util.List;

/**
 * <p>
 * 问诊记录表，存储用户与医生的问诊详情 服务类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
public interface IConsultationService extends IService<Consultation> {
    //创建新问诊记录
    public Consultation startConsultation(Long userId, Long doctorId, Long petId, String consultationType, String description);

    // 用户发送消息
    void sendMessage(Long consultationId, String sender, String messageType, String content, String voiceUrl);

    // 获取某次问诊的所有对话记录
    List<ConsultationMessage> getMessagesByConsultationId(Long consultationId);
}
