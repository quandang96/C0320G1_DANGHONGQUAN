package case_study.module2_wbe.service;

import case_study.module2_wbe.dto.RegisterDto;
import org.springframework.validation.Errors;

public interface RegisterService {
  void saveData(RegisterDto registerDto);
   void validate(Object target, Errors errors);
}
