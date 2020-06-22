package com.validate_form.controller;


import com.validate_form.model.User;
import com.validate_form.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public ModelAndView create() {
        return new ModelAndView("index", "user", new User());
    }

    @PostMapping("/create")
    public ModelAndView result(@Validated User user, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("index");
        } else {
            userService.save(user);
            ModelAndView modelAndView = new ModelAndView("index","message","Congratulations!");
            modelAndView.addObject("user",new User());
            return modelAndView;
        }

    }
}
