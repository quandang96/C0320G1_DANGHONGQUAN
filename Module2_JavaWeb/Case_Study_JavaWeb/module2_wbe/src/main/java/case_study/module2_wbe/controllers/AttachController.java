package case_study.module2_wbe.controllers;
import case_study.module2_wbe.entity.AttachService;
import case_study.module2_wbe.service.AttachInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/attach-service")
public class AttachController {

    @Autowired
    private AttachInterface attachInterface;

    @GetMapping("/create")
    public ModelAndView getAttachService(){
        return new ModelAndView("attachService/create","attachService",new AttachService());
    }

    @PostMapping("/create")
    public ModelAndView attachService(@Valid @ModelAttribute("attachService") AttachService attachService, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("attachService/create");
        if(bindingResult.hasErrors()){
            return modelAndView;
        }
        attachInterface.save(attachService);
        modelAndView.addObject("attachService",new AttachService());
        return modelAndView;
    }
}
