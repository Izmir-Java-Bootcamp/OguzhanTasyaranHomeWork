package com.example.week4homework1.service;

import com.example.week4homework1.entity.BasketProducts;
import com.example.week4homework1.entity.Order;
import com.example.week4homework1.entity.OrderedProducts;
import com.example.week4homework1.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CheckoutService {

    private final OrderRepository orderRepository;

    private final BasketRepository basketRepository;

    private final BasketProductRepository basketProductRepository;

    private final UserRepository userRepository;

    private final OrderedProductsRepository orderedProductsRepository;

    private final ProductRepository productRepository;

    public void createOrder(Long userId, Long basketId) {
        Order order = orderRepository.save(new Order(
                null, userRepository.getById(userId)
        ));

        List<BasketProducts> basketProducts = basketProductRepository.findAllByBasket(basketRepository.getById(basketId));
        basketProducts.forEach(it -> orderedProductsRepository.save(new OrderedProducts(null, order, it.getProduct(), it.getQuantity())));
    }
}
