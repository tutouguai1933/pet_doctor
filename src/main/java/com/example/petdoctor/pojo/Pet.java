package com.example.petdoctor.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 宠物档案表，存储宠物的详细信息，包括品种、性别、体重等
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@ApiModel(value = "Pet对象", description = "宠物档案表，存储宠物的详细信息，包括品种、性别、体重等")
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("宠物的唯一标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("宠物主人ID，引用User表")
    private Long userId;

    @ApiModelProperty("宠物名称")
    private String name;

    @ApiModelProperty("宠物品种")
    private String breed;

    @ApiModelProperty("宠物性别")
    private String gender;

    @ApiModelProperty("宠物出生日期")
    private LocalDate birthDate;

    @ApiModelProperty("宠物到家日期")
    private LocalDate arrivalDate;

    @ApiModelProperty("宠物体重（公斤）")
    private BigDecimal weight;

    @ApiModelProperty("宠物的健康档案信息")
    private String healthRecord;
}
