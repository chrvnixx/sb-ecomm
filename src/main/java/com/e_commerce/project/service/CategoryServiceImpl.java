package com.e_commerce.project.service;

import com.e_commerce.project.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private List<Category>categories =new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public String createCategory(Category category) {
        category.setCategoryId(nextId++);
         categories.add(category);
       return "New Category created";
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categories.stream().filter(c-> c.getCategoryId().equals(categoryId)).findFirst().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
         categories.remove(category);
         return "Category with categoryId:" + categoryId + " has been deleted";
    }

    @Override
    public String updateCategory(Category category, Long categoryId) {
        Optional<Category> optionalCategory = categories.stream().filter(c-> c.getCategoryId().equals(categoryId)).findFirst();
        if(optionalCategory.isPresent()){
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            return "Category with categoryId:" + categoryId + " has been updated";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }


}
