package com.blueocean.mall.provider.service;


import com.blueocean.mall.common.exception.ResourceNotFoundException;
import com.blueocean.mall.provider.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Value("${spring.jpa.showSql}")
    private String value;
    @Test
    public void findByUsernameOrEmailException(){
        System.out.println(value);
        userService.findByUsernameOrEmail("zhangsan","zhangsan")
                .block();
//        assertThrows(ResourceNotFoundException.class,()->
//                userService.findByUsernameOrEmail("zhangsan","zhangsan")
//                        .subscribe(user -> user.toString()));
    }
}
