package com.example.security_form;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class})
public class SecurityFormApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityFormApplication.class, args);
    }

}
