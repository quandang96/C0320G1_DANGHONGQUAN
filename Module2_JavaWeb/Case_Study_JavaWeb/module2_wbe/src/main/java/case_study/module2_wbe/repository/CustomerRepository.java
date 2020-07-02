package case_study.module2_wbe.repository;

import case_study.module2_wbe.entity.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Long> {

    Page<Customer> findAllByStatusIsTrue(Pageable pageable);
     Customer findByIdAndStatusIsTrue(long id);
     Customer findAllByAccount_UserNameAndStatusIsTrue(String name);
     Page<Customer> findAllByNameContainingAndCodeContainingAndAddressContaining( String name, String code, String address, Pageable pageable);
}
