package com.example.petdoctor.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 订单表，记录用户在平台上的购买行为
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@ApiModel(value = "Order对象", description = "订单表，记录用户在平台上的购买行为")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单的唯一标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户ID，引用User表")
    private Long userId;

    @ApiModelProperty("订单日期")
    private LocalDateTime orderDate;

    @ApiModelProperty("订单总价")
    private BigDecimal totalPrice;

    @ApiModelProperty("订单状态")
    private String status;
}
