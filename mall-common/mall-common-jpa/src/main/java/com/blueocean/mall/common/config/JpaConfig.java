package com.blueocean.mall.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import th.co.geniustree.springdata.jpa.repository.support.JpaSpecificationExecutorWithProjectionImpl;

import javax.annotation.PostConstruct;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(repositoryBaseClass = JpaSpecificationExecutorWithProjectionImpl.class)
@Slf4j
public class JpaConfig {
    @Value("${spring.config.name}")
    private String configName;

    @PostConstruct
    public void init(){
        log.info("******加载jpa配置:{}******",configName);
    }
}
