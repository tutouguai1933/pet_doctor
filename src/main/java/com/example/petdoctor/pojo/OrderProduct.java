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
 * 订单与商品关联表，记录订单中包含的商品及数量
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@TableName("order_product")
@ApiModel(value = "OrderProduct对象", description = "订单与商品关联表，记录订单中包含的商品及数量")
public class OrderProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单ID，引用Order表")
    @TableField("order_id")
    private Long orderId;

    @ApiModelProperty("商品ID，引用Product表")
    @TableField("product_id")
    private Long productId;

    @ApiModelProperty("商品购买数量")
    private Integer quantity;
}
