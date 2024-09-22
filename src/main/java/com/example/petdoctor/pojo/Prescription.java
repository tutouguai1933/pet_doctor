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
 * 处方表，存储医生为用户开具的处方
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@ApiModel(value = "Prescription对象", description = "处方表，存储医生为用户开具的处方")
public class Prescription implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("处方的唯一标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("问诊ID，引用Consultation表")
    private Long consultationId;

    @ApiModelProperty("处方开具时间")
    private LocalDateTime prescriptionDate;
}
