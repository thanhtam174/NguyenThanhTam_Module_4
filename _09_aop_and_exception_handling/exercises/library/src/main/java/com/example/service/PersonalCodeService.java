package com.example.service;

import com.example.model.PersonalCode;

public interface PersonalCodeService {
    void save(PersonalCode personalCode);
    PersonalCode findById(Integer id);
    void delete(Integer id);
    PersonalCode findByCode(String code);
}
