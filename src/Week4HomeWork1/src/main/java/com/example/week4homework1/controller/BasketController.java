package com.example.week4homework1.controller;

import com.example.week4homework1.entity.Basket;
import com.example.week4homework1.model.ProductAddRemoveRequest;
import com.example.week4homework1.service.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/basket")
@AllArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @GetMapping("/{id}")
    public Basket getUserBasket(@PathVariable Long id) {
        return basketService.getUserBasket(id);
    }

    @PostMapping
    public void updateProduct(@RequestBody ProductAddRemoveRequest request) {
        basketService.updateProduct(request);
    }

}
