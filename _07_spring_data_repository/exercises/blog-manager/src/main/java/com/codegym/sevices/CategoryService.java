package com.codegym.sevices;

import com.codegym.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    void save(Category category);

    void deleteById(Long id);

    Category findById(Long id);
}
