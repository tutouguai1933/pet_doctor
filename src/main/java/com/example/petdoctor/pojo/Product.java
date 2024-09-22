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
 * 商品表，存储平台出售的宠物商品信息
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@ApiModel(value = "Product对象", description = "商品表，存储平台出售的宠物商品信息")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品的唯一标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("商品描述")
    private String description;

    @ApiModelProperty("商品价格")
    private BigDecimal price;

    @ApiModelProperty("库存数量")
    private Integer stock;
}
