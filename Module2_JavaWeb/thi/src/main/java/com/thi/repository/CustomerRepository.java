package com.thi.repository;

import com.thi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findAllByStatusIsTrue();
    Customer findAllByIdAndStatusIsTrue(Long id);
}
