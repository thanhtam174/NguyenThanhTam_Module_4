package controllers;

import model.service.CurrencyService;
import model.service.impl.CurrencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;
    @GetMapping("/conversion")
    public String getResult(@RequestParam String usd, @RequestParam String rate, Model model){
        Double result = currencyService.convert(Double.parseDouble(usd),Double.parseDouble(rate));
        model.addAttribute("vnd",result);
        return "index";
    }

    @GetMapping()
    public String homePage(){
        return "index";
    }
}
