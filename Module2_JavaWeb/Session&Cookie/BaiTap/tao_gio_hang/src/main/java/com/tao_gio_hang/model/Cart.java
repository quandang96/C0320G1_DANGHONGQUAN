package com.tao_gio_hang.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = Product.class)
    private Map<Product,Quantity> product;

    public Cart() {
    }

    public Map<Product, Quantity> getProduct() {
        product = new HashMap<>();
        return product;
    }

    public void setProduct(Map<Product, Quantity> product) {
        this.product = product;
    }

    public Cart(Long id) {
        this.id = id;

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
