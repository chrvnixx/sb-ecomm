package com.e_commerce.project.service;

import com.e_commerce.project.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();


    String createCategory(Category category);

    void deleteCategory(Long categoryId);
}
