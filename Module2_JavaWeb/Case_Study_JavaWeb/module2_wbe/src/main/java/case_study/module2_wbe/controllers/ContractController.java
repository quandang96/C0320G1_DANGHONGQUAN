package case_study.module2_wbe.controllers;

import case_study.module2_wbe.entity.Contract;
import case_study.module2_wbe.service.ContractService;
import case_study.module2_wbe.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private ServiceInterface serviceInterface;

    @GetMapping("/create/{id}")
    public ModelAndView getContract(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("contract/contract");
        modelAndView.addObject("contract",new Contract());
        modelAndView.addObject("services", serviceInterface.findAllById(id));
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView contract(@Valid @ModelAttribute("contract") Contract contract, BindingResult bindingResult){
        contract.validate(contract,bindingResult);
        ModelAndView modelAndView = new ModelAndView("contract/contract");
        modelAndView.addObject("service",serviceInterface.findAll());
        if(bindingResult.hasErrors()){
            return modelAndView;
        }
        contractService.save(contract);
        modelAndView.addObject("contract",new Contract());
        return modelAndView;

    }
}
