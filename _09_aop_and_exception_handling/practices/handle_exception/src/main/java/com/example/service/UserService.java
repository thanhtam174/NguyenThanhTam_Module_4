package com.example.service;

import com.example.model.User;
import com.example.util.DuplicateEmailException;

public interface UserService {
    void save(User user) throws DuplicateEmailException;
}
