package case_study.module2_wbe.service.impl;
import case_study.module2_wbe.dto.RegisterDto;
import case_study.module2_wbe.encode.EncryptPassword;
import case_study.module2_wbe.entity.Account;
import case_study.module2_wbe.entity.Authority;
import case_study.module2_wbe.entity.Customer;
import case_study.module2_wbe.repository.AuthorityRepository;
import case_study.module2_wbe.service.AccountService;
import case_study.module2_wbe.service.CustomerService;
import case_study.module2_wbe.service.RegisterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Service
public class RegisterServiceImpl  implements RegisterService, Validator {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityRepository authorityRepository;


    public void saveData(RegisterDto registerDto){
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(registerDto,Customer.class);
        customer.setStatus(true);
        customerService.save(customer);
        Account account = modelMapper.map(registerDto,Account.class);
        account.setPassword(EncryptPassword.encryptPassword(registerDto.getPassword()));
        account.setStatus(true);
        account.setAuthority(new Authority(2));
        account.setCustomer(customer);
        accountService.save(account);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterDto registerDto = (RegisterDto) target;

        for (Account account : accountService.findAll()) {
            if (registerDto.getUsername().equals(account.getUserName())) {
                errors.rejectValue("username", "message.username");
                break;
            }
        }

            for (Customer customers : customerService.findAllCustomer()) {
                if (registerDto.getEmail().equals(customers.getEmail())) {
                    errors.rejectValue("email", "message.email");
                    break;
                }
            }
        }

}
