package case_study.module2_wbe.controllers;
import case_study.module2_wbe.entity.Customer;
import case_study.module2_wbe.entity.Service;
import case_study.module2_wbe.service.ServiceInterface;
import case_study.module2_wbe.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceInterface serviceInterface;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @GetMapping("/create")
    public ModelAndView getService(){
        ModelAndView modelAndView =new ModelAndView("service/create");
        modelAndView.addObject("services",new Service());
        modelAndView.addObject("serviceType",serviceTypeService.findAll());
      return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createService(@Valid @ModelAttribute("service") Service service, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("service/create");
        modelAndView.addObject("serviceType",serviceTypeService.findAll());
        if (bindingResult.hasErrors()){
         return modelAndView;
        }
        serviceInterface.save(service);
        modelAndView.addObject("services",new Service());
        return modelAndView;
    }

    @GetMapping("/show-all/{page}")
    public ModelAndView showAll(@PathVariable("page") int page) {
        return new ModelAndView("service/list", "services", serviceInterface.findAllService(page));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView getDelete(@PathVariable("id") Long id){
        ModelAndView modelAndView =new ModelAndView("service/delete","services",serviceInterface.findAllById(id));
        modelAndView.addObject("serviceType",serviceTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Service service){
        serviceInterface.remove(service.getId());
        return "redirect:/service/show-all/1";
    }

    @GetMapping("/update/{id}")
    public ModelAndView getUpdate(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("service/edit");
        modelAndView.addObject("serviceType",serviceTypeService.findAll());
        modelAndView.addObject("services", serviceInterface.findAllById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@Validated @ModelAttribute("services") Service service, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("service/edit");
        modelAndView.addObject("serviceType",serviceTypeService.findAll());
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        serviceInterface.save(service);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable("id") Long id){
        ModelAndView modelAndView =new ModelAndView("service/view","services",serviceInterface.findAllById(id));
        modelAndView.addObject("serviceType",serviceTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/display/{page}")
    public ModelAndView display(@PathVariable("page") int page) {
        return new ModelAndView("service/service", "services", serviceInterface.findAllService(page));
    }

    @GetMapping("/search/{page}")
    public ModelAndView search(@PathVariable int page,
                               @RequestParam String name){
        ModelAndView modelAndView = new ModelAndView("service/list");
        modelAndView.addObject("customers",serviceInterface.findAllByName(name,page));
        return modelAndView;
    }
}
