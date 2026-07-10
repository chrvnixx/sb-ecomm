package com.e_commerce.project.Service;

import com.e_commerce.project.models.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService  {

    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategories(@RequestBody Category category) {
        category.setCategoryId(nextId++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categories.stream().filter(c->c.getCategoryId().equals(categoryId)).findFirst().orElse(null);
        if(category == null)
            return "Category not found";
        categories.remove(category);
        return "Category with categoryId:" + categoryId + " has been deleted!!!";
    }


}
