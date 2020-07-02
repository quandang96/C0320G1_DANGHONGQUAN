package case_study.module2_wbe.repository;

import case_study.module2_wbe.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract,Long> {
}
