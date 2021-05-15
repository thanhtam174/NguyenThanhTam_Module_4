package com.codegym.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductOder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oder_id")
    private Long id;

    @Column(name = "date_oder", columnDefinition = "date")
    private String dateOder;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "bill", joinColumns = @JoinColumn(name = "oder_id") , inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> productOder;

    public ProductOder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateOder() {
        return dateOder;
    }

    public void setDateOder(String dateOder) {
        this.dateOder = dateOder;
    }

    public List<Product> getProductOder() {
        return productOder;
    }

    public void setProductOder(List<Product> productOder) {
        this.productOder = productOder;
    }
}
