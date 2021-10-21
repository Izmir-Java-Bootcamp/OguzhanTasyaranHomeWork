package com.example.week3homework1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductAdditionRequest {
    Product product;
    int quantity;
}
