package case_study.module2_wbe.controllers;
import case_study.module2_wbe.entity.Customer;
import case_study.module2_wbe.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.security.Principal;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/show-all/{page}")
    public ModelAndView showAll(@PathVariable("page") int page) {
        return new ModelAndView("customers/list", "customers", customerService.findAll(page));
    }

    @GetMapping("/")
    public String home(Principal principal, Model model){
        if(principal==null){
            return "register/home";
        }else {
            model.addAttribute("customer",customerService.findAllByAccount_Name(principal.getName()));
        }
        return "register/home";
    }

    @GetMapping("/update/{id}")
    public ModelAndView getUpdate(@PathVariable("id") Long id) {
        return new ModelAndView("customers/update", "customers", customerService.findAllById(id));
    }

    @PostMapping("/update")
    public ModelAndView update(@Validated @ModelAttribute("customers") Customer customer, BindingResult bindingResult) {
        customer.validate(customer, bindingResult);
        ModelAndView modelAndView = new ModelAndView("customers/update");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        customerService.save(customer);
        modelAndView.addObject("message","Congratulations!");
       modelAndView.addObject("customers",customer);
        return modelAndView;
    }


    @GetMapping("/delete/{id}")
    public ModelAndView getDelete(@PathVariable("id") Long id){
        return new ModelAndView("customers/delete","customers",customerService.findAllById(id));
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Customer customer){
        customerService.remove(customer.getId());
        return "redirect:/show-all/1";
    }

    @GetMapping("/search/{page}")
    public ModelAndView search(@PathVariable int page,
                                @RequestParam String name,
                                @RequestParam String code,
                                @RequestParam String address ){
        ModelAndView modelAndView = new ModelAndView("customers/list");
        modelAndView.addObject("customers",customerService.findAllByNameAndCodeAndAddress(name,code,address,page));
        return modelAndView;
    }
}
