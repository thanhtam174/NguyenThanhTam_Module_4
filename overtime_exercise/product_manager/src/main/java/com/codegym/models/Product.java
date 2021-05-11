package com.codegym.models;

import lombok.*;

import javax.persistence.*;



@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "product_name", nullable = false)
    @Getter
    @Setter
    private String productName;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name="detail_id", nullable=false)
    private  Detail detail;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    public Product() {
    }

    public Product(Long id, String productName, Detail detail, Category category) {
        this.id = id;
        this.productName = productName;
        this.detail = detail;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
