package com.example.week4homework1.service;

import com.example.week4homework1.entity.Category;
import com.example.week4homework1.exception.CategoryNotExistsException;
import com.example.week4homework1.model.MainCategoryCreateRequest;
import com.example.week4homework1.model.SubCategoryCreateRequest;
import com.example.week4homework1.model.UpdateCategoryRequest;
import com.example.week4homework1.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void createMainCategory(MainCategoryCreateRequest request) {
        categoryRepository.save(new Category(null, request.getMainCategoryName(), null));
    }

    public void createSubCategory(SubCategoryCreateRequest request) throws CategoryNotExistsException {
        Category category = categoryRepository.findById(request.getParentId()).orElseThrow(CategoryNotExistsException::new);
        categoryRepository.save(new Category(null, category.getParentCategory(), request.getSubCategoryName()));
    }

    public String getParentCategory(Long id) throws CategoryNotExistsException {
        Category category = categoryRepository.findById(id).orElseThrow(CategoryNotExistsException::new);
        return category.getParentCategory();
    }

    public List<Category> getSubCategories(Long id) throws CategoryNotExistsException {
        Category category = categoryRepository.findById(id).orElseThrow(CategoryNotExistsException::new);
        return categoryRepository.findAllByParentCategory(category.getParentCategory());
    }

    public void updateCategory(UpdateCategoryRequest updateCategoryRequest) throws CategoryNotExistsException {
        Category category = categoryRepository.findById(updateCategoryRequest.getId()).orElseThrow(CategoryNotExistsException::new);
        category.setParentCategory(updateCategoryRequest.getParentCategoryName());
        category.setSubCategory(updateCategoryRequest.getSubCategoryName());
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
