package product_management_application.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product_management_application.model.Product;
import product_management_application.services.ProductService;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;


    @GetMapping("/product")
    public ModelAndView home(){
  return new ModelAndView("home","product",productService.findAllProduct());
}
    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("create" ,"product", new Product());
    }
    @PostMapping("/create")
    public String saveCreate(Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("message","Create Success!");
        return "redirect:/product";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
       return new ModelAndView("edit","product",productService.findProductById(id));
    }
    @PostMapping("/update")
    public String update(Product product){
        productService.update(product);
        return "redirect:/product";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        return new ModelAndView("delete","product",productService.findProductById(id) );
    }
    @PostMapping("/delete")
    public String deleteProduct(Product product){
        productService.remove(product.getId());
        return "redirect:/product";
    }
    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id){
        return new ModelAndView("view","product",productService.findProductById(id));
    }
    @PostMapping("/search")
    public ModelAndView search(@RequestParam String name){
        return new ModelAndView("search","product",productService.findProductByName(name));
    }


}
