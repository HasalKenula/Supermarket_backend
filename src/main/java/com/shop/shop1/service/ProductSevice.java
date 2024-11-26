package com.shop.shop1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.shop1.entity.Product;

@Service
public interface ProductSevice {
    List<Product> getAllProducts();
    Product createProduct(Product product);
    Product getProductByID(Long id);
    Product updteProduct(Long id,Product product);
    void deleteProduct(Long id);
    void whatSize(Long id);
}
