package controllers;

import model.service.DictionaryService;
import model.service.impl.DictionaryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictonaryController {
    @GetMapping("/search")
    public String getResult(@RequestParam String searchString, Model model){
        DictionaryService dictionaryService = new  DictionaryServiceImpl();
        String result = dictionaryService.search(searchString);
        model.addAttribute("result",result);
        return "index";
    }

    @GetMapping()
    public String getHomePage(){
        return "index";
    }
}
