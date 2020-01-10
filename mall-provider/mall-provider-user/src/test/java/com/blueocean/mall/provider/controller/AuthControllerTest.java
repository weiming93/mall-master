package com.blueocean.mall.provider.controller;

import com.blueocean.mall.provider.payload.dto.LoginDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;

@WithMockUser
@SpringBootTest
@AutoConfigureWebTestClient
public class AuthControllerTest {
    @Autowired
    WebTestClient rest;

    @Test
    public void signin() {
        rest.mutateWith(csrf()).post()
                .uri("/api/auth/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new LoginDto("zhangsan","123456"))
                .exchange()
                .expectBody().consumeWith(System.out::println);
    }
}
