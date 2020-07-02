package com.thi.service;

import com.thi.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();
    void save(Customer customer);
    void delete(Long id);
    Customer findById(Long id);
}
