package com.codegym.model.service.impl;

import com.codegym.model.bean.Product;
import com.codegym.model.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 6", 400.0, "Iphone"));
        products.put(2, new Product(2, "Iphone 7 Plus", 600.0, "Iphone"));
        products.put(3, new Product(3, "Samsung Galaxy S8", 500.0, "Samsung"));
        products.put(4, new Product(4, "Xiaomi Note 8", 400.0, "Xiaomi"));
        products.put(5, new Product(5, "Iphone X", 800.0, "Iphone"));
        products.put(6, new Product(6, "Iphone 12", 1000.0 ,"Iphone"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
