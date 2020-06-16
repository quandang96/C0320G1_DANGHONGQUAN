package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Calculator {
    @GetMapping("/")
    public String viewCalculator(){
        return "index";
    }
    @PostMapping("/calculator")
    public String resultCalculator(Model model, @RequestParam float number1, @RequestParam float number2,
                                   @RequestParam String add) {
        float result;
        switch (add) {
            case "addition":
                result = number1 + number2;
                break;
            case "subtraction":
                result = number1 - number2;
                break;
            case "multiplication":
                result = number1 * number2;
                break;
            case "division":
                result = number1 / number2;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + add);
        }
        model.addAttribute("result", result);
        return "index";

    }
}
