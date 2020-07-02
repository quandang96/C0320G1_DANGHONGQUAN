package case_study.module2_wbe.service.impl;
import case_study.module2_wbe.entity.Account;
import case_study.module2_wbe.repository.AccountRepository;
import case_study.module2_wbe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void save(Account account) {
    accountRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
