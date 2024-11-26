package com.shop.shop1.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.shop1.dto.ProductReq;
import com.shop.shop1.entity.Category;
import com.shop.shop1.entity.Product;
import com.shop.shop1.service.CategoryService;
import com.shop.shop1.service.ProductSevice;

@RestController
@CrossOrigin(origins="*")
public class ProductController {
    
    @Autowired
    private ProductSevice productSevice;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody ProductReq productReq){
        try {
            Product newProduct=new Product();
            newProduct.setName(productReq.getName());
            newProduct.setDescription(productReq.getDescription());
            newProduct.setPrice(productReq.getPrice());
            newProduct.setSize(productReq.getSize());

            Category categoryData=categoryService.getCategoryById(productReq.getCategoryId());
            newProduct.setCategory(categoryData);

            Product productData=productSevice.createProduct(newProduct);
            return ResponseEntity.status(201).body(productData);
        } catch (Exception e) {
           return ResponseEntity.status(404).body(e.getMessage());
        }
    }


    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList=productSevice.getAllProducts();
        return ResponseEntity.status(201).body(productList);
    }

    @PutMapping("/product/{productId}")
    public  ResponseEntity<Product> updteProduct(@PathVariable Long productId,@RequestBody ProductReq productReq){
        try {
            Product productData=productSevice.getProductByID(productId);
            if(productData==null){
                return ResponseEntity.status(404).body(null);
            }else{
                productData.setName(productReq.getName());
                productData.setDescription(productReq.getDescription());
                productData.setPrice(productReq.getPrice());
                productData.setSize(productReq.getSize());

                Category categorylist=categoryService.getCategoryById(productReq.getCategoryId());
                productData.setCategory(categorylist);

                Product productlist=productSevice.updteProduct(productId, productData);
                return ResponseEntity.status(201).body(productlist);
            }
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/product/{productId}")
    public void deleteProduct(@PathVariable Long productId){
        productSevice.deleteProduct(productId);
    }

    




}
