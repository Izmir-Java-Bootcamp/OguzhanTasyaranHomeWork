package com.example.week4homework1.service;

import com.example.week4homework1.entity.Basket;
import com.example.week4homework1.entity.BasketProducts;
import com.example.week4homework1.entity.Product;
import com.example.week4homework1.model.ProductAddRemoveRequest;
import com.example.week4homework1.repository.BasketProductRepository;
import com.example.week4homework1.repository.BasketRepository;
import com.example.week4homework1.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;

    private final BasketProductRepository basketProductRepository;

    private final ProductRepository productRepository;

    public Basket getUserBasket(Long id) {
        return basketRepository.getById(id);
    }

    public void updateProduct(ProductAddRemoveRequest request) {
        int quantity = Math.max(request.getQuantity(), 0);
        if (quantity == 0) {
            basketProductRepository.deleteByBasketIdAndProductId(request.getBasketId(), request.getProductId());
        } else {
            basketProductRepository.save(
                    new BasketProducts(
                            null,
                            basketRepository.getById(request.getBasketId()),
                            productRepository.getById(request.getProductId()),
                            quantity)
            );
        }
    }
}
