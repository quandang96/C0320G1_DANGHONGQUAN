package case_study.module2_wbe.service;
import case_study.module2_wbe.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CustomerService {
   List<Customer> findAllCustomer();
    Page<Customer> findAll(int page);
    void save (Customer customer);
    void remove(Long id);
    Customer findAllById(Long id);
    Customer findAllByAccount_Name(String name);
 Page<Customer> findAllByNameAndCodeAndAddress( String name, String code, String address, int pageable);

}
