package com.e_commerce.project.Service.Service;

import com.e_commerce.project.Models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategories(Category category);
}
