package com.tao_gio_hang.service.impl;
import com.sun.istack.NotNull;
import com.tao_gio_hang.model.Cart;
import com.tao_gio_hang.model.Product;
import com.tao_gio_hang.model.Quantity;
import com.tao_gio_hang.repository.ProductRepository;
import com.tao_gio_hang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Map<Product, Quantity> findById(Long id, Map<Product, Quantity> cart) {

        if(cart.size()!=0 ){
            for(Product product:cart.keySet()) {
                if(product.getId().equals(id)){
                    cart.get(product).increment();
                    return cart;
                }
            }
        }
        cart.put(productRepository.findById(id).orElse(null), new Quantity(1));
        return cart;
    }
}
