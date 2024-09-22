package com.example.petdoctor.controller;

import com.example.petdoctor.pojo.Consultation;
import com.example.petdoctor.pojo.ConsultationMessage;
import com.example.petdoctor.service.IConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 问诊记录表，存储用户与医生的问诊详情 前端控制器
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@RestController
@RequestMapping("/api/consultations")
public class ConsultationController {

    @Autowired
    private IConsultationService consultationService;

    // 用户发起问诊
    @PostMapping("/start")
    public Consultation startConsultation(
            @RequestParam Long userId,
            @RequestParam Long doctorId,
            @RequestParam Long petId,
            @RequestParam String consultationType,
            @RequestParam String description) {
        return consultationService.startConsultation(userId, doctorId, petId, consultationType, description);
    }

    // 发送消息（文本或语音）
    @PostMapping("/sendMessage")
    public String sendMessage(
            @RequestParam Long consultationId,
            @RequestParam String sender,
            @RequestParam String messageType,
            @RequestParam(required = false) String content,
            @RequestParam(required = false) String voiceUrl) {
        try {
            consultationService.sendMessage(consultationId, sender, messageType, content, voiceUrl);
            return "消息发送成功";
        } catch (RuntimeException e) {
            throw new RuntimeException("发送消息失败: " + e.getMessage());
        }
    }

    // 获取某次问诊的所有消息
    @GetMapping("/{consultationId}/messages")
    public List<ConsultationMessage> getMessages(@PathVariable Long consultationId) {
        return consultationService.getMessagesByConsultationId(consultationId);
    }
}
