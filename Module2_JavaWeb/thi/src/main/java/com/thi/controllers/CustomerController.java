package com.thi.controllers;

import com.thi.entity.Customer;
import com.thi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/create")
    public ModelAndView getCreate(){
        return new ModelAndView("create","customer",new Customer());
    }

    @PostMapping("/create")
    public ModelAndView saveCreate(@Validated @ModelAttribute Customer customer, BindingResult bindingResult,){
        ModelAndView modelAndView = new ModelAndView("create");
        if(bindingResult.hasErrors()){
            return modelAndView;
        }
        customerService.save(customer);


    }
}
