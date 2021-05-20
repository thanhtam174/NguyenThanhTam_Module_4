package com.example.service;

import com.example.model.Book;

import java.util.List;

public interface BookService {
    void save(Book book);
    void deleteById(Integer id);
    Book findById(Integer id);
    List<Book> findAll();
}
