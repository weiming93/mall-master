package com.emond.mall;

import com.emond.mall.common.annotation.EnableMallRedis;
import com.emond.mall.common.annotation.MallCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaRepositories
@MallCloudApplication
@EnableMallRedis
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}
