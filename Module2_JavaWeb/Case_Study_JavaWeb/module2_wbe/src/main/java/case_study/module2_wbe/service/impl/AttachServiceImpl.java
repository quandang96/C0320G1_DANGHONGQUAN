package case_study.module2_wbe.service.impl;

import case_study.module2_wbe.entity.AttachService;
import case_study.module2_wbe.repository.AttachServiceRepository;
import case_study.module2_wbe.service.AttachInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImpl implements AttachInterface {

    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public void save(AttachService attachService) {
        attachService.setStatus(true);
        attachServiceRepository.save(attachService);
    }
}
