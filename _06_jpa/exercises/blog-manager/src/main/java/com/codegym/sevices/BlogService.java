package com.codegym.sevices;


import com.codegym.models.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void deleteById(Integer id);

   Blog findById(Integer id);
}
