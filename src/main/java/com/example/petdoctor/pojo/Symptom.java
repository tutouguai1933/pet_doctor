package com.example.petdoctor.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 症状表，存储不同种类宠物的常见症状及相关建议
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@ApiModel(value = "Symptom对象", description = "症状表，存储不同种类宠物的常见症状及相关建议")
public class Symptom implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("症状的唯一标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("症状名称")
    private String name;

    @ApiModelProperty("症状的详细描述")
    private String description;

    @ApiModelProperty("症状所属类别，标识是猫、狗还是其他宠物")
    private String category;

    @ApiModelProperty("医生的建议或预防措施")
    private String advice;
}
