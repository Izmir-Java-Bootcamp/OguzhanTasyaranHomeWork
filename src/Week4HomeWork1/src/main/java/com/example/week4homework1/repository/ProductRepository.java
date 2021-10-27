package com.example.week4homework1.repository;

import com.example.week4homework1.entity.Category;
import com.example.week4homework1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(Category category);
}
