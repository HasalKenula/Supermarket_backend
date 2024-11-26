package com.shop.shop1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.shop1.dto.OrderReq;
import com.shop.shop1.entity.Order;
import com.shop.shop1.entity.Product;
import com.shop.shop1.service.OrderService;
import com.shop.shop1.service.ProductSevice;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductSevice productSevice;

    @PostMapping("/order")
    public  ResponseEntity<?> createOrder(@RequestBody OrderReq orderReq){
        try {
            Order newOrder=new Order();
            List<Long> ordersID=orderReq.getProductsId();
            newOrder.setTotalPrice(0.0);
            List<Product> productsData=new ArrayList<>();

            ordersID.forEach(productIDS->{
                Product productdata=productSevice.getProductByID(productIDS);
                productSevice.whatSize(productIDS);
                if(productdata!=null){
                    //productdata.setSize(productdata.getSize()-1);
                    productsData.add(productdata);
                    newOrder.setTotalPrice(newOrder.getTotalPrice()+productdata.getPrice());

                }
            });

            newOrder.setOrderedProducts(productsData);
            Order orderlist=orderService.createOrder(newOrder);


           
            return ResponseEntity.status(201).body(orderlist);
        } catch (Exception e) {
           return ResponseEntity.status(404).body(e.getMessage());
        }
        
    }

    @GetMapping("/order")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orderDetails=orderService.getAllOrders();
        return ResponseEntity.status(201).body(orderDetails);
    }

}
