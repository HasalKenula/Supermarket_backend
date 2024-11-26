package com.shop.shop1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.shop.shop1.entity.Product;
import com.shop.shop1.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductSevice{
    @Autowired
    private ProductRepository productRepository;

   

    @Override
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    
    @Override
    public  Product getProductByID(Long id){
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public  Product updteProduct(Long id,Product product){
        Product productData= productRepository.findById(id).orElse(null);

        if(productData==null){
            return null;
        }else{
            productData.setName(product.getName());
            productData.setDescription(product.getDescription());
            productData.setPrice(product.getPrice());
            productData.setSize(product.getSize());
            return productRepository.save(productData);
        }

    }

    @Override
    public  void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    @Override
    public void whatSize(Long id){
        Product productData= productRepository.findById(id).orElse(null);

        if(productData!=null){
           
      
            productData.setName(productData.getName());
            productData.setDescription(productData.getDescription());
            productData.setPrice(productData.getPrice());
            productData.setSize(productData.getSize()-1);
             productRepository.save(productData);
        }

    }

}
