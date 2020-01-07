package com.blueocean.mall.provider.controller;

import com.blueocean.mall.provider.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

@WithMockUser(username = "admin", roles = {"admin"})
@SpringBootTest
public class UserControllerTest {

    @Autowired
    WebTestClient rest;

    User user;

    @BeforeEach
    public void setUp(){
        user = new User();
        user.setName("张三");
        user.setUsername("zhangsan");
        user.setEmail("zhangsan@gmail.com");
        user.setEnabled(true);
        user.setPhone("13500000000");
    }

    @Test
    public void createUser() {
        rest.post()
                .uri("/api/user")
                .bodyValue(user)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }
}
