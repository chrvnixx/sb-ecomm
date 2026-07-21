package com.e_commerce.project.service;

import com.e_commerce.project.models.Category;
import com.e_commerce.project.repositories.CategoryRepository;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public String createCategory(Category category) {
        categoryRepository.save(category);
        return "New Category added!!!";
    }


}
