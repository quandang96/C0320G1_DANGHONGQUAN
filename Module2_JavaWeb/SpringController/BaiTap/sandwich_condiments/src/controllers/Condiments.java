package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Condiments {
    @GetMapping("/")
    public String selectCondiment(){
        return "index";
    }
    @PostMapping("/save")
    public String save(Model model, @RequestParam(name = "condiments", required = false, defaultValue="no condiments") String[] condiments){
      model.addAttribute("condiment", condiments);
      return "sandwich";
    }
}
