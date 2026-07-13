package com.e_commerce.project.controllers;

import com.e_commerce.project.models.Category;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private List<Category> categories = new ArrayList<>();

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories(){
        return categories;
    }

    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category){
        categories.add(category);
        return "Category added";
    }

    @DeleteMapping("/api/public/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId){
        Category category = categories.stream().filter(c-> c.getCategoryId().equals(categoryId)).findFirst().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        categories.remove(category);
        return "Category with categoryId:" + categoryId + " has been deleted";
    }
}
