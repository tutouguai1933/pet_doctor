package com.example.petdoctor.mapper;

import com.example.petdoctor.pojo.OrderProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 订单与商品关联表，记录订单中包含的商品及数量 Mapper 接口
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
public interface OrderProductMapper extends BaseMapper<OrderProduct> {

}
