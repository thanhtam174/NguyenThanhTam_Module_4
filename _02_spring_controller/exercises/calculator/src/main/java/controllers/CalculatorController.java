package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping
    public String getHome(){
        return "index";
    }

    @GetMapping("/calculator")
    public  String calculate(@RequestParam(defaultValue = "0") Double firstOperand, @RequestParam(defaultValue = "0") Double secondOperand,
                             @RequestParam String operator, Model model){

        switch (operator){
            case "Addition":
                model.addAttribute("result",firstOperand+secondOperand);
                break;
            case "Subtraction":
                model.addAttribute("result",firstOperand-secondOperand);
                break;
            case "Multiplication":
                model.addAttribute("result",firstOperand*secondOperand);
                break;
            case "Division":
                if (secondOperand != 0){
                    model.addAttribute("result",firstOperand/secondOperand);
                }else {
                    model.addAttribute("result","Can't divide by zero");
                }
                break;
            default:
                throw new RuntimeException("Invalid operation");
        }
        return "index";
    }
}
