package case_study.module2_wbe.controllers;

import case_study.module2_wbe.dto.RegisterDto;
import case_study.module2_wbe.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/register")
    public ModelAndView getRegister() {
        return new ModelAndView("register/sign-in", "registerDto", new RegisterDto());
    }

    @PostMapping("/register")
    public ModelAndView create(@Valid @ModelAttribute("registerDto") RegisterDto registerDto, BindingResult bindingResult) {
        registerService.validate(registerDto, bindingResult);
        registerDto.validate(registerDto, bindingResult);
        ModelAndView modelAndView = new ModelAndView("register/sign-in");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        registerService.saveData(registerDto);
        modelAndView.addObject("registerDto", new RegisterDto());
        return modelAndView;

    }

    @GetMapping("/login")
    public String login(){
        return "register/login";
    }
}
