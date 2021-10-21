package com.example.week3homework1.controller;

import com.example.week3homework1.model.Cart;
import com.example.week3homework1.model.PaymentType;
import com.example.week3homework1.model.ProductAdditionRequest;
import com.example.week3homework1.service.CheckoutService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
public class CheckoutContoller {

    private final CheckoutService checkoutService;


    public CheckoutContoller(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping
    public void addProductCheckout(ProductAdditionRequest productAdditionRequest) {
        checkoutService.addProduct(productAdditionRequest);
    }

    @GetMapping
    public Cart getCart() {
        return checkoutService.getCart();
    }

    @GetMapping("/payment?{paymentType}")
    public String makePayment(@RequestBody Cart cart, @PathVariable PaymentType paymentType){
        return checkoutService.pay(cart, paymentType);
    }
}
