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
 * 药品与症状关联表，存储能够缓解某些症状的药品信息
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@TableName("medicine_symptom")
@ApiModel(value = "MedicineSymptom对象", description = "药品与症状关联表，存储能够缓解某些症状的药品信息")
public class MedicineSymptom implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("药品ID，引用Medicine表")
    @TableField("medicine_id")
    private Long medicineId;

    @ApiModelProperty("症状ID，引用Symptom表")
    @TableField("symptom_id")
    private Long symptomId;
}
