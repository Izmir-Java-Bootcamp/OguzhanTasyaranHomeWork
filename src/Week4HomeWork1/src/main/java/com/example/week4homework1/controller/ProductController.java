package com.example.week4homework1.controller;

import com.example.week4homework1.entity.Product;
import com.example.week4homework1.exception.CategoryNotExistsException;
import com.example.week4homework1.exception.ProductNotExistException;
import com.example.week4homework1.model.ProductCreateRequest;
import com.example.week4homework1.model.ProductUpdateRequest;
import com.example.week4homework1.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void createProduct(@RequestBody ProductCreateRequest productCreateRequest) throws CategoryNotExistsException {
        productService.createProduct(productCreateRequest);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) throws ProductNotExistException {
        return productService.getProduct(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteById(id);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductUpdateRequest productUpdateRequest) throws CategoryNotExistsException, ProductNotExistException {
        productService.updateProduct(productUpdateRequest);
    }
}
