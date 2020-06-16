package com.customer_manager.repository;

import com.customer_manager.model.Customer;
import com.customer_manager.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Iterable<Customer> findAllByProvince(Province province);

}
