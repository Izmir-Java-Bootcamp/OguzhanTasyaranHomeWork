package com.example.week4homework1.controller;

import com.example.week4homework1.entity.Category;
import com.example.week4homework1.entity.Product;
import com.example.week4homework1.exception.CategoryNotExistsException;
import com.example.week4homework1.model.MainCategoryCreateRequest;
import com.example.week4homework1.model.SubCategoryCreateRequest;
import com.example.week4homework1.model.UpdateCategoryRequest;
import com.example.week4homework1.service.CategoryService;
import com.example.week4homework1.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    private final ProductService productService;


    @PostMapping("/main")
    public void createMainCategory(@RequestBody MainCategoryCreateRequest request){
        categoryService.createMainCategory(request);
    }

    @PostMapping("/sub")
    public void createSubCategory(@RequestBody SubCategoryCreateRequest request) throws CategoryNotExistsException {
        categoryService.createSubCategory(request);
    }

    @GetMapping("/{id}/parent")
    public String getParentCategory(@PathVariable Long id) throws CategoryNotExistsException {
        return categoryService.getParentCategory(id);
    }

    @GetMapping("/{id}/products")
    public List<Product> getProducts(@PathVariable Long id) throws CategoryNotExistsException {
        return productService.getProductList(id);
    }

    @GetMapping("/{id}/subcategories")
    public List<Category> getSubCategories(@PathVariable Long id) throws CategoryNotExistsException {
        return categoryService.getSubCategories(id);
    }

    @PutMapping
    public void updateCategory(@RequestBody UpdateCategoryRequest updateCategoryRequest) throws CategoryNotExistsException {
        categoryService.updateCategory(updateCategoryRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
