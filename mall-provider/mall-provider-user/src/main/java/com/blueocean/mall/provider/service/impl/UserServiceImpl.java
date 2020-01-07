package com.blueocean.mall.provider.service.impl;

import com.blueocean.mall.common.exception.EntityExistException;
import com.blueocean.mall.common.exception.ResourceNotFoundException;
import com.blueocean.mall.provider.domain.User;
import com.blueocean.mall.provider.repository.UserRepository;
import com.blueocean.mall.provider.service.UserService;
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
        return userRepository.findByUsernameOrEmail(username, email)
                .orElseThrow(() -> new ResourceNotFoundException("账号", "username", username));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User create(User user) {
        if(userRepository.existsByUsername(user.getUsername())) {
            throw new EntityExistException("账号",user.getUsername());
        }
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new EntityExistException("邮箱",user.getEmail());
        }
        user.setPassword(passwordEncoder.encode("123456"));
        return userRepository.save(user);
    }
}
