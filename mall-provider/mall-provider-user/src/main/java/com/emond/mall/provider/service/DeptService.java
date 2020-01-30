package com.emond.mall.provider.service;

import com.emond.mall.provider.domain.Dept;

public interface DeptService {

    Dept create(Dept dept);

    void update(Dept dept);

    void delete(Long id);
}
