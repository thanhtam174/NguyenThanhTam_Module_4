package com.codegym.repositories;

import com.codegym.models.Blog;
import com.codegym.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findAllByCategory(Category category, Pageable pageable);
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
}
