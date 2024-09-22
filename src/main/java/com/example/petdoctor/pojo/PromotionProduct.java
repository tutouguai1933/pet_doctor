package com.example.petdoctor.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 促销活动与商品的关联表，记录促销活动涉及的商品
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@TableName("promotion_product")
@ApiModel(value = "PromotionProduct对象", description = "促销活动与商品的关联表，记录促销活动涉及的商品")
public class PromotionProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("促销活动ID，引用Promotion表")
    @TableField("promotion_id")
    private Long promotionId;

    @ApiModelProperty("商品ID，引用Product表")
    @TableField("product_id")
    private Long productId;

    @ApiModelProperty("促销折扣")
    private BigDecimal discount;
}
