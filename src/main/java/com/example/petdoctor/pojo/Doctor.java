package com.example.petdoctor.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 医生表，存储医生的基本信息和资质
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@ApiModel(value = "Doctor对象", description = "医生表，存储医生的基本信息和资质")
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("医生的唯一标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("医生的姓名")
    private String name;

    @ApiModelProperty("医生的执业编号")
    private String licenseNumber;

    @ApiModelProperty("医生擅长的专业方向")
    private String specialization;

    @ApiModelProperty("从业年限")
    private Integer experienceYears;

    @ApiModelProperty("医生的评分")
    private Double rating;

    @ApiModelProperty("医生头像的URL")
    private String profilePictureUrl;

    @ApiModelProperty("图文问诊价格")
    private BigDecimal consultationPrice;

    @ApiModelProperty("电话问诊价格")
    private BigDecimal phoneConsultationPrice;

    @ApiModelProperty("医生是否认证")
    private Byte verified;
}
