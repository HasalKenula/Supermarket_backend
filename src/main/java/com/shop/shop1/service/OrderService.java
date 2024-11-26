package com.shop.shop1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.shop1.entity.Order;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    Order createOrder(Order order);
}
