package com.codegym.sevices;


import com.codegym.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    void deleteById(Long id);

   Blog findById(Long id);


}
