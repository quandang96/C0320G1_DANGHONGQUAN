package com.thi.service.impl;

import com.thi.entity.Customer;
import com.thi.repository.CustomerRepository;
import com.thi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customer.setStatus(true);
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        Customer customer =customerRepository.findAllByIdAndStatusIsTrue(id);
        customer.setStatus(false);
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findAllByIdAndStatusIsTrue(id);
    }
}
