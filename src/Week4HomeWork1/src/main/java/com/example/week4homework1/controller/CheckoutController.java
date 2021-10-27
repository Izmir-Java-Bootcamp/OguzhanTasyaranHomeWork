package com.example.week4homework1.controller;

import com.example.week4homework1.service.CheckoutService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/checkout")
@AllArgsConstructor
public class CheckoutController {

    private final CheckoutService checkoutService;

    @PostMapping("/{userId}/{basketId}")
    public void createOrder(@PathVariable Long userId, @PathVariable Long basketId){
        checkoutService.createOrder(userId, basketId);
    }

}
