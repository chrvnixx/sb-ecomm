package com.e_commerce.project.controller;

import com.e_commerce.project.Service.CategoryService;
import com.e_commerce.project.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    public String createCategories(@RequestBody Category category) {
        categoryService.createCategories(category);
        return "New category added";
    }

    @DeleteMapping("/api/public/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId){
        String status = categoryService.deleteCategory(categoryId);
        return status;
    }


}
