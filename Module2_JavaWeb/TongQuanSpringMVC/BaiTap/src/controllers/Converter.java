package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpRequest;

@Controller
public class Converter  {
    @PostMapping("/convert")
    public String getConverter(@RequestParam("rate") String rate, @RequestParam("usd") String usd, Model model){
        float vnd = Float.parseFloat(rate )* Float.parseFloat(usd);
        model.addAttribute("vnd",vnd);
        model.addAttribute("rate",rate);
        model.addAttribute("usd",usd);
        return "converter";
    }
    @GetMapping("/convert")
    public String getView(){
        return "index";
    }

}
