package com.emond.mall.provider.controller;

import com.emond.mall.provider.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;

@WithMockUser(username = "admin", roles = "system:admin")
@SpringBootTest
@AutoConfigureWebTestClient
public class UserControllerTest {

    @Autowired
    WebTestClient rest;

    User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setName("张三");
        user.setUsername("zhangsan");
        user.setEmail("zhangsan@gmail.com");
        user.setEnabled(true);
        user.setPhone("13500000000");
    }

    @Test
    public void createUser() {
        rest.mutateWith(csrf()).post()
                .uri("/api/user")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(user)
                .exchange()
                .expectStatus()
                .isCreated();
    }
}
