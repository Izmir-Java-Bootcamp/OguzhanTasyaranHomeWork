package com.example.week4homework1.service;

import com.example.week4homework1.entity.Category;
import com.example.week4homework1.entity.Product;
import com.example.week4homework1.exception.CategoryNotExistsException;
import com.example.week4homework1.exception.ProductNotExistException;
import com.example.week4homework1.model.ProductCreateRequest;
import com.example.week4homework1.model.ProductUpdateRequest;
import com.example.week4homework1.repository.CategoryRepository;
import com.example.week4homework1.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<Product> getProductList(Long id) throws CategoryNotExistsException {
        Category category = categoryRepository.findById(id).orElseThrow(CategoryNotExistsException::new);
        return productRepository.findAllByCategory(category);
    }

    public void createProduct(ProductCreateRequest productCreateRequest) throws CategoryNotExistsException {
        Product product = Product.builder()
                .category(categoryRepository.findById(productCreateRequest.getCategoryId()).orElseThrow(CategoryNotExistsException::new))
                .description(productCreateRequest.getDescription())
                .name(productCreateRequest.getName())
                .price(productCreateRequest.getPrice())
                .build();
        productRepository.save(product);
    }

    public Product getProduct(Long id) throws ProductNotExistException {
        return productRepository.findById(id).orElseThrow(ProductNotExistException::new);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(ProductUpdateRequest productUpdateRequest) throws CategoryNotExistsException, ProductNotExistException {
        Product product = productRepository.findById(productUpdateRequest.getId()).orElseThrow(ProductNotExistException::new);
        Category category = categoryRepository.findById(productUpdateRequest.getCategoryId()).orElseThrow(CategoryNotExistsException::new);
        product.setCategory(category);
        product.setDescription(productUpdateRequest.getDescription());
        product.setName(productUpdateRequest.getName());
        product.setPrice(productUpdateRequest.getPrice());
        productRepository.save(product);
    }


}
