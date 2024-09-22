package com.example.petdoctor.controller;

import com.example.petdoctor.pojo.Order;
import com.example.petdoctor.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 订单表，记录用户在平台上的购买行为 前端控制器
 * </p>
 *
 * @author djy
 * @since 2024-09-21
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    // 创建订单
    @PostMapping("/create")
    public Order createOrder(@RequestParam Long userId, @RequestParam BigDecimal totalAmount) {
        return orderService.createOrder(userId, totalAmount);
    }

    // 更新订单状态
    @PutMapping("/updateStatus/{orderId}")
    public String updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        boolean success = orderService.updateOrderStatus(orderId, status);
        if (success) {
            return "订单状态更新成功";
        } else {
            throw new RuntimeException("订单ID不存在");
        }
    }

    // 根据用户ID获取所有订单
    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    // 获取订单详情
    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        Order order = orderService.getById(orderId);
        if (order == null) {
            throw new RuntimeException("订单ID不存在");
        }
        return order;
    }
}
