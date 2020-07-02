package case_study.module2_wbe.service.impl;

import case_study.module2_wbe.entity.Account;
import case_study.module2_wbe.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAllByUserName(username);
        if(account == null)
            throw new UsernameNotFoundException("User " + username + " was not found in the database");

        List<GrantedAuthority> grantedList = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(account.getAuthority().getName());
        grantedList.add(grantedAuthority);

        return new User(account.getUserName(),account.getPassword(),grantedList);


    }
}
