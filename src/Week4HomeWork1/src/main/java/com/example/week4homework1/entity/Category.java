package com.example.week4homework1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name="parent_category", nullable = false)
    private String parentCategory;

    @Column(name="sub_category")
    private String subCategory;
}