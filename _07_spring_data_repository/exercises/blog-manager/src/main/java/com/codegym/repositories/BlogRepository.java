package com.codegym.repositories;

import com.codegym.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    Page<Blog> findAllByTitleContaining(String search, Pageable pageable);
    Page<Blog> findAllByCategoryId(Long id, Pageable pageable);
}
