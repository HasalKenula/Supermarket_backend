package com.shop.shop1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.shop1.entity.Category;

@Service
public interface CategoryService {
    Category createCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(Long id);

}
