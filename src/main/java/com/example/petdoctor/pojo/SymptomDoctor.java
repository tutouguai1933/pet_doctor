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
 * 症状与医生的推荐表，记录某症状推荐的医生及其推荐级别
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@TableName("symptom_doctor")
@ApiModel(value = "SymptomDoctor对象", description = "症状与医生的推荐表，记录某症状推荐的医生及其推荐级别")
public class SymptomDoctor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("症状ID，引用Symptom表")
    @TableField("symptom_id")
    private Long symptomId;

    @ApiModelProperty("医生ID，引用Doctor表")
    @TableField("doctor_id")
    private Long doctorId;

    @ApiModelProperty("推荐等级，值越大越推荐")
    private Integer recommendationLevel;
}
