package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentController {
    @GetMapping
    public String getHome(){
        return "index";
    }

    @GetMapping("/save")
    public String save(@RequestParam(name = "condiment", defaultValue = "none") String[] condiments, Model model ) {
            model.addAttribute("condiments", condiments);
        return "save";
    }
}
