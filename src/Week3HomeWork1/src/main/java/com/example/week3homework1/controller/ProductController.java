package com.example.week3homework1.controller;

import com.example.week3homework1.model.ProductCreateRequest;
import com.example.week3homework1.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void addProduct(ProductCreateRequest req){
        productService.addProduct(req);
    }

}
