package com.tao_gio_hang.service;


import com.tao_gio_hang.model.Product;
import com.tao_gio_hang.model.Quantity;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> findAll();
    Map<Product,Quantity> findById(Long id, Map<Product, Quantity> cart);
}
