package com.codegym.model.repositories;

import com.codegym.model.bean.Login;
import com.codegym.model.bean.User;

public interface UserRepository {
    User checkLogin(Login login);
}
