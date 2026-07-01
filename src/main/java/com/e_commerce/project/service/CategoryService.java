package com.e_commerce.project.service;

import com.e_commerce.project.model.Category;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryService {

     List<Category> getAllCategories();
     void createCategories(@RequestBody Category category);
}
