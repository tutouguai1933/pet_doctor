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
 * 推荐商品表，存储系统推荐给用户的商品信息
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@ApiModel(value = "Recommendedproduct对象", description = "推荐商品表，存储系统推荐给用户的商品信息")
public class Recommendedproduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("推荐商品的唯一标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品ID，引用Product表")
    private Long productId;

    @ApiModelProperty("推荐理由，描述该商品为何被推荐")
    private String recommendationReason;

    @ApiModelProperty("显示顺序，控制商品的展示顺序")
    private Integer displayOrder;
}
