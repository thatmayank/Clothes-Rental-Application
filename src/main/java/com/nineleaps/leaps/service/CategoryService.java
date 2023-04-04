package com.nineleaps.leaps.service;

import com.nineleaps.leaps.model.Category;
import com.nineleaps.leaps.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements CategoryServiceInterface {
    //Linking Repository using constructor injection
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> listCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void updateCategory(Long id, Category updateCategory) {
        Category category = categoryRepository.findById(id).get();
        if (category != null) {
            category.setCategoryName(updateCategory.getCategoryName());
            category.setDescription(updateCategory.getDescription());
            category.setImageUrl(updateCategory.getImageUrl());
        }
        categoryRepository.save(category);
    }

    @Override
    public Category readCategory(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    @Override
    public Optional<Category> readCategory(Long id) {
        return categoryRepository.findById(id);
    }
}

