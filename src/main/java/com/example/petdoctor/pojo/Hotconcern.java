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
 * 热门关注表，存储用户热门查询的症状及分类信息
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@ApiModel(value = "Hotconcern对象", description = "热门关注表，存储用户热门查询的症状及分类信息")
public class Hotconcern implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("热门关注的唯一标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("症状ID，引用Symptom表")
    private Long symptomId;

    @ApiModelProperty("类别，标识是猫还是狗相关的症状")
    private String category;

    @ApiModelProperty("显示顺序，控制热门关注的展示顺序")
    private Integer displayOrder;
}
