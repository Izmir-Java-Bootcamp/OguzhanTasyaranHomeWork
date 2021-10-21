package com.example.week3homework1.model;

import java.util.Objects;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
public class Product {
    private String name;
    private String description;
    private double price;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && name.equals(product.name) && description.equals(product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price);
    }
}
