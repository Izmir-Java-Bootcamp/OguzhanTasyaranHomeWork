package com.example.week3homework1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.week3homework1.model.MainCategory;
import com.example.week3homework1.model.Product;
import com.example.week3homework1.model.ProductCreateRequest;
import com.example.week3homework1.model.SubCategory;
import lombok.var;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private Map<MainCategory, List<SubCategory>> categoryListMap;
    private Map<SubCategory, List<Product>> subCategoryProductMap;

    public void addProduct(ProductCreateRequest req) {
        if (categoryListMap.containsKey(req.getMainCategory())) {
            categoryListMap.get(req.getMainCategory()).add(req.getSubCategory());
        } else {
            categoryListMap.put(req.getMainCategory(), List.of(req.getSubCategory()));
        }

        if (subCategoryProductMap.containsKey(req.getSubCategory())) {
            subCategoryProductMap.get(req.getSubCategory()).add(
                    Product.builder()
                            .name(req.getName())
                            .price(req.getPrice())
                            .description(req.getDescription()).build()
            );
        } else {
            subCategoryProductMap.put(req.getSubCategory(), List.of(Product.builder()
                    .name(req.getName())
                    .price(req.getPrice())
                    .description(req.getDescription()).build()
            ));
        }
    }

    public List<Product> searchProduct(String query) {
        List<Product> resultSet = new ArrayList<>();
        for (var entry : subCategoryProductMap.entrySet()) {
            resultSet.addAll(entry.getValue().stream().filter(it -> it.getName().contains(query)).collect(Collectors.toList()));
        }
        return resultSet;
    }
}