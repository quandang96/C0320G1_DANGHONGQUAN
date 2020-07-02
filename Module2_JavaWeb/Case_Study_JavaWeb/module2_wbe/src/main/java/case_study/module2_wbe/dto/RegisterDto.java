package case_study.module2_wbe.service.impl;
import case_study.module2_wbe.entity.Account;
import case_study.module2_wbe.entity.Customer;
import case_study.module2_wbe.service.AccountService;
import case_study.module2_wbe.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.Pattern;


public class RegisterDto {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private AccountServiceImpl accountService;

    private String username;
    @Pattern(regexp = "^([-\\w.])+[a-zA-Z\\d]@(\\w+\\.)+(\\w+)$", message = "Email is wrong format")
    private String email;
    private String password;
    private String confirmPassword;


    public RegisterDto() {
    }



    public void saveData(RegisterDto registerDto){
        ModelMapper modelMapper = new ModelMapper();
       Customer customer = modelMapper.map(registerDto,Customer.class);
        customerService.save(customer);
        Account account = modelMapper.map(registerDto,Account.class);
        account.setCustomer(customer);
        accountService.save(account);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
