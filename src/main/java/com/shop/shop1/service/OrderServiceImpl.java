package com.shop.shop1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.shop1.entity.Order;
import com.shop.shop1.repository.OrderReppository;

@Service
public class OrderServiceImpl implements OrderService {
    
   

    @Autowired
    private OrderReppository orderReppository;

    @Override
    public List<Order> getAllOrders(){
        return orderReppository.findAll();
    }

    @Override
    public  Order createOrder(Order order){
        return orderReppository.save(order);
    }
}
