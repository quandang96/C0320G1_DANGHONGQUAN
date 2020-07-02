package case_study.module2_wbe.service.impl;
import case_study.module2_wbe.entity.Customer;
import case_study.module2_wbe.repository.CustomerRepository;
import case_study.module2_wbe.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl  implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(int page) {
        Pageable pageable = PageRequest.of(page-1,3, Sort.by("name").ascending());
        return customerRepository.findAllByStatusIsTrue(pageable);
    }


    @Override
    public void save(Customer customer) {
        customer.setStatus(true);
          customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        Customer customer =customerRepository.findByIdAndStatusIsTrue(id);
        customer.setStatus(false);
       customerRepository.save(customer);
    }

    @Override
    public Customer findAllById( Long id) {
        return customerRepository.findByIdAndStatusIsTrue(id);
    }

    @Override
    public Customer findAllByAccount_Name(String name) {
        return customerRepository.findAllByAccount_UserNameAndStatusIsTrue(name);
    }

    @Override
    public Page<Customer> findAllByNameAndCodeAndAddress(String name, String code, String address, int page) {
        Pageable pageable = PageRequest.of(page-1,3, Sort.by("name").ascending());
        return customerRepository.findAllByNameContainingAndCodeContainingAndAddressContaining(name,code,address,pageable);
    }
}
