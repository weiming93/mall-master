package com.emond.mall.auth.service;


import com.emond.mall.auth.domain.User;
import com.emond.mall.auth.mapper.UserPrincipalMapper;
import com.emond.mall.auth.repository.UserRepository;
import com.emond.mall.common.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @description:
 * @author: Emond Chan
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new ResourceNotFoundException("账号", "username", usernameOrEmail));
        return UserPrincipalMapper.create(user);
    }
}
