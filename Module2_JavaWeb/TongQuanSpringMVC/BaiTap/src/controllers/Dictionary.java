package controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Dictionary {
    @GetMapping("/translate")
    public String getViewDictionary(){
        return "simpleDictionary";
    }
    @PostMapping("/translate")
    public String getDictionary(@RequestParam("txtSearch") String search, Model model){
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
        model.addAttribute("txtSearch",search);
        String result = dictionary.get(search);
        String results;
        if(result != null){
            results=result;
        } else {
            results= "Not found";
        }
        model.addAttribute("result",results);
        return "dictionary";
    }
}
