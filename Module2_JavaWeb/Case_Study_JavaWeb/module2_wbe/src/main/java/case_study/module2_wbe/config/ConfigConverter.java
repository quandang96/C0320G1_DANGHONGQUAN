package case_study.module2_wbe.config;

import case_study.module2_wbe.converter.BirthdayDateConverter;
import case_study.module2_wbe.converter.DateConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigConverter implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new BirthdayDateConverter());
        registry.addConverter(new DateConverter());
    }
}
