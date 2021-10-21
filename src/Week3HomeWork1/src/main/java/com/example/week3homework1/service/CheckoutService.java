package com.example.week3homework1.service;

import java.util.Map;
import com.example.week3homework1.model.Cart;
import com.example.week3homework1.model.PaymentType;
import com.example.week3homework1.model.Product;
import com.example.week3homework1.model.ProductAdditionRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class CheckoutService {
    private Map<Product, Integer> productQuantityMap;


    @Value("discount.percentage")
    private int discountPercentage;

    @Value("delivery.fee.limit")
    private double deliveryFeeLimit;

    @Value("delivery.fee.price")
    private double deliveryFee;

    @Value("card.commission")
    private double creditCardCommission;

    public void addProduct(ProductAdditionRequest productAdditionRequest) {
        productQuantityMap.merge(productAdditionRequest.getProduct(), productAdditionRequest.getQuantity(), Integer::sum);
    }

    public Cart getCart() {
        double grandTotal = 0.0;
        double discountedTotal = 0.0;
        double appliedDeliveryFee = grandTotal > this.deliveryFeeLimit ? this.deliveryFee : 0.0;
        for (var entry : productQuantityMap.entrySet()) {
            grandTotal += entry.getKey().getPrice() * entry.getValue();
        }
        if (grandTotal > 1000) {
            discountedTotal = grandTotal - grandTotal * discountPercentage / 100;
        } else {
            if ((long) productQuantityMap.keySet().size() > 5) {
                Product buy2Take3Available = productQuantityMap.entrySet().stream().filter(e -> e.getValue() > 3)
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .orElse(null);
                if (buy2Take3Available != null) {
                    discountedTotal = grandTotal - buy2Take3Available.getPrice();
                }
            }
        }
        return Cart.builder()
                .cartTotal(grandTotal)
                .discountedTotal(discountedTotal)
                .deliveryFee(appliedDeliveryFee)
                .productQuantityMap(productQuantityMap)
                .build();
    }

    public String pay(Cart cart, PaymentType paymentType) {
        if (paymentType.equals(PaymentType.CASH)) {
            return "Your order successfully processed";
        }
        return "Your order successfully processed and %" + creditCardCommission + " is taken.";

    }
