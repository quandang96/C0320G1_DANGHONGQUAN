package case_study.module2_wbe.service.impl;
import case_study.module2_wbe.entity.ServiceType;
import case_study.module2_wbe.repository.ServiceTypeRepository;
import case_study.module2_wbe.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;


    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
