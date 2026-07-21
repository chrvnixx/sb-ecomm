package com.e_commerce.project.controllers;

import com.e_commerce.project.models.Category;
import com.e_commerce.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getAllCategories(){

            return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping("/admin/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
       try {
           String status = categoryService.createCategory(category);
           return ResponseEntity.ok(status);
       } catch (ResponseStatusException e) {
           return new ResponseEntity<>(e.getReason(), e.getStatusCode());
       }
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        try {
            categoryService.deleteCategory(categoryId);
            return ResponseEntity.ok("Category has been deleted!!!");
        } catch (ResponseStatusException e) {
           return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category, @PathVariable Long categoryId){
       try {
           String status = categoryService.updateCategory(category, categoryId);
           return ResponseEntity.ok(status);
       } catch (ResponseStatusException e) {
           return new ResponseEntity<>(e.getReason(), e.getStatusCode());
       }
    }
}
