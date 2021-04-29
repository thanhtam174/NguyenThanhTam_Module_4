package com.codegym.model.services.impl;

import com.codegym.model.bean.Login;
import com.codegym.model.bean.User;
import com.codegym.model.repositories.UserRepository;
import com.codegym.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkLogin(Login login) {
        return userRepository.checkLogin(login);
    }
}
