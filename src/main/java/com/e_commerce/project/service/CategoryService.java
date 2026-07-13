package com.e_commerce.project.service;

import com.e_commerce.project.models.Category;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void creatCategory(@RequestBody Category category);
    void deleteCategory(@PathVariable Long categoryId);
}
