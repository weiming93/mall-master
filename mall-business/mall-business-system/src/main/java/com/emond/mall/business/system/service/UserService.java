package com.emond.mall.business.system.service;


import com.emond.mall.business.system.domain.User;
import com.emond.mall.business.system.domain.query.UserQueryCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface UserService {


    User create(User resources);

    void delete(Set<Long> ids);

    User findById(Long currentUserId);

    void update(User resources);

    Page<User> getUserPage(UserQueryCriteria criteria, Pageable pageable);

}
