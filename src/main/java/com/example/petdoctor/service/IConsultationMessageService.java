package com.example.petdoctor.service;

import com.example.petdoctor.pojo.ConsultationMessage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 诊室记录表，存储用户与医生的每次问诊记录，包括诊断和治疗方案 服务类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
public interface IConsultationMessageService extends IService<ConsultationMessage> {
    // 保存消息
    void saveMessage(ConsultationMessage message);
}
