package com.example.petdoctor.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 诊室记录表，存储用户与医生的每次问诊记录，包括诊断和治疗方案
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@ApiModel(value = "ConsultationMessage对象", description = "问诊消息表，存储用户与医生的对话记录，包括文本和语音消息")
public class ConsultationMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("消息的唯一标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("问诊ID")
    private Long consultationId;

    @ApiModelProperty("消息发送者，用户或医生")
    private String sender;

    @ApiModelProperty("消息类型，文本或语音")
    private String messageType;

    @ApiModelProperty("文本消息内容")
    private String messageContent;

    @ApiModelProperty("语音消息的URL")
    private String voiceUrl;

    @ApiModelProperty("消息发送时间")
    private LocalDateTime sendTime;
}
