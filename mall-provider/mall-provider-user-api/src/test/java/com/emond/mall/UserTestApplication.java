package com.emond.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories
public class UserTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserTestApplication.class);
    }

}