package com.customer_manager;

import com.customer_manager.services.ProvinceService;
import formatter.ProvinceFormatter;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class CustomerManagerApplication  {
    private ApplicationContext applicationContext;

//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new ProvinceFormatter(applicationContext.getBean(ProvinceService.class)));
//    }
    public static void main(String[] args) {
        SpringApplication.run(CustomerManagerApplication.class, args);
    }


//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//
//    }
}
