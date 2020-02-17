package com.emond.mall.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories
@PropertySource("classpath:application-base-test.yml")
public class MallCommonJpaApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(MallCommonJpaApplicationTest.class);
    }
}
