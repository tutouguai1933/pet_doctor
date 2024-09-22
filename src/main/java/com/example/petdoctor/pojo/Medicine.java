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
 * 药品表，存储平台提供的药品信息
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@ApiModel(value = "Medicine对象", description = "药品表，存储平台提供的药品信息")
public class Medicine implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("药品的唯一标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("药品名称")
    private String name;

    @ApiModelProperty("药品描述")
    private String description;

    @ApiModelProperty("药品价格")
    private BigDecimal price;

    @ApiModelProperty("药品库存数量")
    private Integer stock;
}
