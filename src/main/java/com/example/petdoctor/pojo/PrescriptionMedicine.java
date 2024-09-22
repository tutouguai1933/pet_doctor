package com.example.petdoctor.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 处方与药品的关联表，记录每张处方中的药品信息
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@TableName("prescription_medicine")
@ApiModel(value = "PrescriptionMedicine对象", description = "处方与药品的关联表，记录每张处方中的药品信息")
public class PrescriptionMedicine implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("处方ID，引用Prescription表")
    @TableField("prescription_id")
    private Long prescriptionId;

    @ApiModelProperty("药品ID，引用Medicine表")
    @TableField("medicine_id")
    private Long medicineId;

    @ApiModelProperty("药品数量")
    private Integer quantity;
}
