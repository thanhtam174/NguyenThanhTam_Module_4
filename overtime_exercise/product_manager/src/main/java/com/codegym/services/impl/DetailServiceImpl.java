package com.codegym.services.impl;

import com.codegym.models.Detail;
import com.codegym.repositories.DetailRepository;
import com.codegym.services.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    DetailRepository detailRepository;

    @Override
    public List<Detail> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public void save(Detail detail) {
        detailRepository.save(detail);
    }

    @Override
    public void deleteById(Long id) {
        detailRepository.deleteById(id);
    }

    @Override
    public Detail findById(Long id) {
        return detailRepository.findById(id).orElse(null);
    }
}
