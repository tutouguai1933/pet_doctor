package com.example.petdoctor.service;

import com.example.petdoctor.pojo.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 订单表，记录用户在平台上的购买行为 服务类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
public interface IOrderService extends IService<Order> {
    // 创建订单
    Order createOrder(Long userId, BigDecimal totalAmount);

    // 根据用户ID查询订单
    List<Order> getOrdersByUserId(Long userId);

    // 更新订单状态
    boolean updateOrderStatus(Long orderId, String status);
}
