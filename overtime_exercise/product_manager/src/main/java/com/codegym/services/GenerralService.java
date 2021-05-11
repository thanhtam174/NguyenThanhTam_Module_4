package com.codegym.services;

import java.util.List;

public interface GenerralService <E>{
    List<E> findAll();

    void save(E e);

    void deleteById(Long id);

    E findById(Long id);
}
