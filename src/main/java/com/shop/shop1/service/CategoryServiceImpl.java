package com.shop.shop1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.shop1.entity.Category;
import com.shop.shop1.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @Override
    public  Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }
}
