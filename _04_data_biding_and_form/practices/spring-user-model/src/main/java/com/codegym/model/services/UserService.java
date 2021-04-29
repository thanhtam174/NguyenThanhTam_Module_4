package com.codegym.model.services;

import com.codegym.model.bean.Login;
import com.codegym.model.bean.User;

public interface UserService {
    User checkLogin(Login login);
}
