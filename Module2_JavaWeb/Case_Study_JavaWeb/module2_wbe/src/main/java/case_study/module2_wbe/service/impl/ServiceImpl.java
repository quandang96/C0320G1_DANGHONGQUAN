package case_study.module2_wbe.service.impl;
import case_study.module2_wbe.entity.Customer;
import case_study.module2_wbe.entity.Service;
import case_study.module2_wbe.repository.ServiceRepository;
import case_study.module2_wbe.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements ServiceInterface {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(Service service) {
          service.setStatus(true);
          serviceRepository.save(service);
    }

    @Override
    public Page<Service> findAllService(int page) {
        Pageable pageable = PageRequest.of(page-1,3, Sort.by("name").ascending());
        return serviceRepository.findAllByStatusIsTrue(pageable);
    }

    @Override
    public void remove(Long id) {
        Service service =serviceRepository.findAllByIdAndStatusIsTrue(id);
        service.setStatus(false);
        serviceRepository.save(service);
    }

    @Override
    public Page<Service> findAllByName(String name,int page) {
        Pageable pageable = PageRequest.of(page-1,3, Sort.by("name").ascending());
        return serviceRepository.findAllByNameAndStatusIsTrue(name,pageable);
    }

    @Override
    public Service findAllById(Long id) {
        return serviceRepository.findAllByIdAndStatusIsTrue(id);
    }
}
