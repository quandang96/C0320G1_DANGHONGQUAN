package case_study.module2_wbe.repository;

import case_study.module2_wbe.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    Authority findAllByName(String name);
}
