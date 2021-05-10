package com.codegym.sevices.impl;

import com.codegym.models.Blog;
import com.codegym.models.Category;
import com.codegym.repositories.BlogRepository;
import com.codegym.sevices.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findAllByCategory(Category category, Pageable pageable) {
        return blogRepository.findAllByCategory(category,pageable);
    }

    @Override
    public Page<Blog> findAllByTitleContaining(String title, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(title,pageable);
    }
}
