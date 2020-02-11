package com.emond.mall.business.user.service.impl;

import com.emond.mall.business.user.repository.UserRepository;
import com.emond.mall.business.user.service.UserService;
import com.emond.mall.common.exception.EntityExistException;
import com.emond.mall.common.exception.ResourceNotFoundException;

import com.emond.mall.provider.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public User findByUsernameOrEmail(String username, String email) {
        return userRepository.findByUsernameOrEmail(username,email)
                .orElseThrow(() -> new ResourceNotFoundException("账号", "username", username));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User create(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new EntityExistException("账号", user.getUsername());
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EntityExistException("邮箱", user.getEmail());
        }
        user.setPassword(passwordEncoder.encode("123456"));

        return userRepository.save(user);
    }
}
