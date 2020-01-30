package com.emond.mall.provider.service.impl;

import com.emond.mall.common.exception.EntityExistException;
import com.emond.mall.common.exception.ResourceNotFoundException;
import com.emond.mall.provider.domain.User;
import com.emond.mall.provider.repository.UserRepository;
import com.emond.mall.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private Scheduler jdbcScheduler;

    @Override
    public Mono<User> findByUsernameOrEmail(String username, String email) {
        return Mono
            .defer(() -> Mono.justOrEmpty(userRepository.findByUsernameOrEmail(username, email))
                    .switchIfEmpty(Mono.error(new ResourceNotFoundException("账号", "username", username)))
            ).subscribeOn(jdbcScheduler);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Mono<User> create(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new EntityExistException("账号", user.getUsername());
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EntityExistException("邮箱", user.getEmail());
        }
        user.setPassword(passwordEncoder.encode("123456"));

        return Mono.just(userRepository.save(user));
    }
}
