package com.tao_gio_hang.controllers;

import com.tao_gio_hang.model.Cart;
import com.tao_gio_hang.model.Product;
import com.tao_gio_hang.model.Quantity;
import com.tao_gio_hang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public Map<Product, Quantity> cart(){
        Cart cart = new Cart();
        return cart.getProduct() ;
    }

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ModelAndView getAllProduct(){
        return new ModelAndView("index","product",productService.findAll());

    }

    @GetMapping("/view/{id}")
    public ModelAndView viewProduct(@PathVariable("id") Long id){
        return new ModelAndView("view","product",productService.findById(id));
    }

    @GetMapping("/buy/{id}")
    public String buyProduct(@PathVariable("id") Long id, @SessionAttribute("cart") Map<Product, Quantity> cart){
        cart.put(productService.findById(id),new Quantity(1));
        return "cart";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable("id") Long id){
        return new ModelAndView("cart");
    }
}
