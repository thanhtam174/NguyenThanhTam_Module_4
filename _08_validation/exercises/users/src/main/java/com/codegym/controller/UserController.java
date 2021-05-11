package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ModelAndView getList(){
        return new ModelAndView("list","users",userService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView creatForm(){
        return new ModelAndView("create","user",new User());
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("create");
        } else {
            userService.save(user);
            return new ModelAndView("create", "mess", "create successful!");
        }
    }
}
