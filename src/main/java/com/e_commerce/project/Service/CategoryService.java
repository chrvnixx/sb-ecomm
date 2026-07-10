package com.e_commerce.project.Service;

import com.e_commerce.project.models.Category;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryService {

    List<Category>getAllCategories();
    void createCategories(@RequestBody Category category);


    String deleteCategory(Long categoryId);
}
