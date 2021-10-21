package com.example.week3homework1.model;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cart {
    private Map<Product, Integer> productQuantityMap;
    private double cartTotal;
    private double discountedTotal;
    private double deliveryFee;
}
