package case_study.module2_wbe.service.impl;

import case_study.module2_wbe.entity.Contract;
import case_study.module2_wbe.repository.ContractRepository;
import case_study.module2_wbe.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contract.setStatus(true);
       contractRepository.save(contract);
    }
}
