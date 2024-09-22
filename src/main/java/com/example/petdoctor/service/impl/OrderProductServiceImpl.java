package com.example.petdoctor.service.impl;

import com.example.petdoctor.pojo.OrderProduct;
import com.example.petdoctor.mapper.OrderProductMapper;
import com.example.petdoctor.service.IOrderProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单与商品关联表，记录订单中包含的商品及数量 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Service
public class OrderProductServiceImpl extends ServiceImpl<OrderProductMapper, OrderProduct> implements IOrderProductService {

}
