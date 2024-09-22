package com.example.petdoctor.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 促销活动表，存储平台的促销活动信息
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Getter
@Setter
@ApiModel(value = "Promotion对象", description = "促销活动表，存储平台的促销活动信息")
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("促销活动的唯一标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("促销活动名称")
    private String name;

    @ApiModelProperty("促销活动开始日期")
    private LocalDate startDate;

    @ApiModelProperty("促销活动结束日期")
    private LocalDate endDate;

    @ApiModelProperty("促销活动描述")
    private String description;
}
