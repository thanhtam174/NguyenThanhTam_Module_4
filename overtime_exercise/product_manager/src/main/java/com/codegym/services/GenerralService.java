package com.codegym.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenerralService <E>{
    Page<E> findAll(Pageable pageable);

    void save(E e);

    void deleteById(Long id);

    E findById(Long id);
}
