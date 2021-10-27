package com.example.week4homework1.repository;

import com.example.week4homework1.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByParentCategory(String parentCategory);
}
