package com.codegym.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id", nullable = false)
    private Long id;
    private Double price;

    @Column(columnDefinition = "text")
    private String decription;

    @OneToOne(mappedBy ="detail",cascade = CascadeType.ALL)
    private Product product;

    public Detail() {
    }

    public Detail(Long id, Double price, String decription, Product product) {
        this.id = id;
        this.price = price;
        this.decription = decription;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
