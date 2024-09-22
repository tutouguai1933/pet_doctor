package com.example.petdoctor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.petdoctor.pojo.Order;
import com.example.petdoctor.mapper.OrderMapper;
import com.example.petdoctor.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 订单表，记录用户在平台上的购买行为 服务实现类
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Override
    public Order createOrder(Long userId, BigDecimal totalAmount) {
        // 创建新订单
        Order order = new Order();
        order.setUserId(userId);
        order.setTotalPrice(totalAmount);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("未支付");
        this.save(order);
        return order;
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        // 根据用户ID查询订单
        return this.list(new QueryWrapper<Order>().eq("user_id", userId));
    }

    @Override
    public boolean updateOrderStatus(Long orderId, String status) {
        // 更新订单状态
        Order order = this.getById(orderId);
        if (order != null) {
            order.setStatus(status);
            return this.updateById(order);
        }
        return false;
    }
}
