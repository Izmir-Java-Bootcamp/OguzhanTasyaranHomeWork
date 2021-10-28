package com.example.week4homework1.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "ordered_products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrderedProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name="quantity")
    private Integer quantity;
}