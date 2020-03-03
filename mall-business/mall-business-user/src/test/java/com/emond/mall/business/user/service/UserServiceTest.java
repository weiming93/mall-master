package com.emond.mall.business.user.service;

import com.emond.mall.provider.user.domain.Role;
import com.emond.mall.provider.user.dto.RoleDTO;
import com.emond.mall.provider.user.dto.UserDTO;
import com.google.common.collect.Sets;


import com.emond.mall.provider.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;
    @Test
    public void findByUsernameOrEmail(){
        UserDTO user = userService.findByUsernameOrEmail("admin", "admin");
        Set<RoleDTO> roles = user.getRoles();
        for (RoleDTO role : roles) {
            System.out.println(role.getName());
        }
        assertEquals("admin",user.getName());
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
