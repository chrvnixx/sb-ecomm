package com.e_commerce.project.service;

import com.e_commerce.project.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    public List<Category> categories = new ArrayList<>();


    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategories(Category category) {
        categories.add(category);
    }
}
