package com.emond.mall.common.repository;

import com.emond.mall.common.domain.User;
import com.emond.mall.common.projection.UserProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void findProjectionById(){
        User user = new User();
        userRepository.save(user);

        UserProjection userProjection = userRepository.findProjectionById(user.getId());
        assertEquals(user.getId(),userProjection.getId());

    }
}
