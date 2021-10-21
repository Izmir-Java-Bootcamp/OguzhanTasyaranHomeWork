package com.example.week3homework1.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductCreateRequest {
    MainCategory mainCategory;
    SubCategory subCategory;
    String name;
    String description;
    double price;
}
