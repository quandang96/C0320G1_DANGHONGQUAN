package case_study.module2_wbe.service;

import case_study.module2_wbe.entity.Account;


import java.util.List;


public interface AccountService {
    void save(Account account);
    List<Account> findAll();
}
