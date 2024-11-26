package com.shop.shop1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.shop1.entity.Category;

import com.shop.shop1.service.CategoryService;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        if(category.getName()==null||category.getName()==""){
         
            return ResponseEntity.status(401).body("Please Enter  the valid name");
        }

        try {
            Category Createcategory=categoryService.createCategory(category);
            return ResponseEntity.status(201).body(Createcategory);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }

    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> getCategories=categoryService.getAllCategories();
        return ResponseEntity.status(201).body(getCategories);
    }

  
        
}
