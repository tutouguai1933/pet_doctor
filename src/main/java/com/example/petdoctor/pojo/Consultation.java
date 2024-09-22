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
 * 问诊记录表，存储用户与医生的问诊详情
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@ApiModel(value = "Consultation对象", description = "问诊表，存储用户与医生的问诊信息")
public class Consultation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("问诊的唯一标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("医生ID")
    private Long doctorId;

    @ApiModelProperty("宠物ID")
    private Long petId;

    @ApiModelProperty("问诊类型，图文或电话")
    private String consultationType;

    @ApiModelProperty("问诊状态，未处理或已处理")
    private String status;

    @ApiModelProperty("问诊描述")
    private String description;

    @ApiModelProperty("问诊创建时间")
    private LocalDateTime consultationDate;

    @ApiModelProperty("最后一条消息的时间")
    private LocalDateTime lastMessageDate;
}
