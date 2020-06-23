package com.tao_gio_hang.controllers;

import com.tao_gio_hang.model.Cart;
import com.tao_gio_hang.model.Product;
import com.tao_gio_hang.model.Quantity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class CartController {

    @GetMapping("/cart")
    public ModelAndView getCart(@SessionAttribute("cart") Map<Product,Quantity> cart ){
        return new ModelAndView("cart","cart",cart);
    }
}
