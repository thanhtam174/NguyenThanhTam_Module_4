package com.codegym.sevices;

import com.codegym.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    void save(Category category);

    void deleteById(Long id);

    Category findById(Long id);
}
