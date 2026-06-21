package com.e_commerce.project.controllers;

import com.e_commerce.project.models.CategoryModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    private List<CategoryModel> categories = new ArrayList<>();
    
    @GetMapping("/api/public/categories")
    public List<CategoryModel> getCategories(){
        return categories;
    }
    
    @PostMapping("api/public/categories")
    public String createCategory(@RequestBody CategoryModel category ){
        categories.add(category);
        return "Category added successfully";
    }
}
