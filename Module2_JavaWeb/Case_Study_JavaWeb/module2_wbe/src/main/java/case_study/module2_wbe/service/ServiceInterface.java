package case_study.module2_wbe.service;

import case_study.module2_wbe.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceInterface {
    List<Service> findAll();
    void save (Service service);
   Page<Service> findAllService(int page);
   Service findAllById(Long id);
     void remove(Long id);
    Page<Service> findAllByName(String name, int page);
}
