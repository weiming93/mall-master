package com.blueocean.mall.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import th.co.geniustree.springdata.jpa.repository.support.JpaSpecificationExecutorWithProjectionImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = JpaSpecificationExecutorWithProjectionImpl.class)
@PropertySource("classpath:application-jpa-test.yml")
public class MallCommonJpaApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(MallCommonJpaApplicationTest.class);
    }
}
