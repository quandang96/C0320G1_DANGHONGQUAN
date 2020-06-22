package com.tao_gio_hang.service;


import com.tao_gio_hang.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}
