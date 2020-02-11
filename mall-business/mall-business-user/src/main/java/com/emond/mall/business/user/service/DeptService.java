package com.emond.mall.business.user.service;

import com.emond.mall.provider.user.domain.Dept;

public interface DeptService {

    Dept create(Dept dept);

    void update(Dept dept);

    void delete(Long id);
}
