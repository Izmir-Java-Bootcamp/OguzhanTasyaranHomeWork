package com.example.week4homework1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "basket_products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BasketProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;
}
