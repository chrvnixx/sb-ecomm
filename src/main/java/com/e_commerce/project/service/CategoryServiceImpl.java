package com.e_commerce.project.service;

import com.e_commerce.project.models.Category;
import com.e_commerce.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

//    private List<Category> categories = new ArrayList<>();
    @Autowired
    private CategoryRepository categoryRepository;
//    private Long nextId = 1L;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
//        category.setCategoryId(nextId++);
        categoryRepository.save(category);

    }

    @Override
    public String deleteCategory(Long categoryId) {
       Category existingCategory = categoryRepository.findById(categoryId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found"));
       categoryRepository.delete(existingCategory);
       return "Category deleted";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
      Category existingCategory = categoryRepository.findById(categoryId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
      existingCategory.setCategoryName(category.getCategoryName());
      return categoryRepository.save(existingCategory);

    }
}
