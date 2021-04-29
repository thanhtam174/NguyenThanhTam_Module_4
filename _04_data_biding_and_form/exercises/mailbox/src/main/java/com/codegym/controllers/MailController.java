package com.codegym.controllers;

import com.codegym.model.bean.SettingMail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MailController {

    @GetMapping("/setting")
    public ModelAndView getMail(Model model){

        List<String> language = new ArrayList<>();
        language.add("English");
        language.add("Vietnamese");
        language.add("Chinese");
        language.add("Japanese");
        List<Integer> pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);

        model.addAttribute("languages",language);
        model.addAttribute("pageSizes",pageSize);
        return new ModelAndView("setting","setting",new SettingMail());
    }

    @PostMapping("/info")
    public ModelAndView getInfo(@ModelAttribute SettingMail settingMail){
        return new ModelAndView("info","setting",settingMail);
    }
}
