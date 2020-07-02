package case_study.module2_wbe.service;

import case_study.module2_wbe.entity.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();
    void save(Contract contract);
}
