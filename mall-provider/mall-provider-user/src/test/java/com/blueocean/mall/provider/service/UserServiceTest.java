package com.blueocean.mall.provider.service;


import com.blueocean.mall.common.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findByUsernameOrEmailException(){
        assertThrows(ResourceNotFoundException.class,()->
                userService.findByUsernameOrEmail("zhangsan","zhangsan")
                        .block());
    }
}
