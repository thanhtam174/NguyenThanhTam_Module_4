package com.codegym.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
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

    @ManyToMany(mappedBy = "productOder")
    private List<ProductOder> oderSet;

    public Product() {
    }

    public Product(Long id, String productName, Detail detail, Category category, List<ProductOder> oderSet) {
        this.id = id;
        this.productName = productName;
        this.detail = detail;
        this.category = category;
        this.oderSet = oderSet;
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

    public List<ProductOder> getOderSet() {
        return oderSet;
    }

    public void setOderSet(List<ProductOder> oderSet) {
        this.oderSet = oderSet;
    }
}
