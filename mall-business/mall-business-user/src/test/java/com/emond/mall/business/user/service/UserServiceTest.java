package com.emond.mall.business.user.service;
import java.time.Instant;

import com.emond.mall.provider.user.domain.Role;
import com.google.common.collect.Sets;


import com.emond.mall.business.user.repository.UserRepository;
import com.emond.mall.provider.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;
    @Test
    public void findByUsernameOrEmailException(){

    }

    @Test
    public void create(){
        User user = new User();
        user.setName("admin");
        user.setUsername("admin");
        user.setEmail("admin@admin.com");
        user.setPhone("18888888888");
        user.setEnabled(true);
        Role role = new Role();
        role.setName("用户添加");
        role.setPermission("user:add");

        roleService.create(role);
        user.setRoles(Sets.newHashSet(role));
        userService.create(user);
    }
}
