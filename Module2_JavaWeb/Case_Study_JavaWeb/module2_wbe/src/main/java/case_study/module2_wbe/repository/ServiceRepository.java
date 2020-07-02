package case_study.module2_wbe.repository;

import case_study.module2_wbe.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {
    Page<Service> findAllByStatusIsTrue(Pageable pageable);
    Service findAllByIdAndStatusIsTrue(Long id);
    Page<Service> findAllByNameAndStatusIsTrue(String name,Pageable pageable);
}
