package com.tao_gio_hang.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer quantity;

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

    public Cart(Long id, String name, Integer quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
