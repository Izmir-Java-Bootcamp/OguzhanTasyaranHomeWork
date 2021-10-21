package com.example.week3homework1.controller;

import com.example.week3homework1.model.Product;
import com.example.week3homework1.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final ProductService productService;

    public SearchController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> searchProducts(@PathVariable String query){
        return productService.searchProduct(query);
    }
}
