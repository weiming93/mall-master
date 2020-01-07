package com.blueocean.mall.provider.service;

import com.blueocean.mall.provider.domain.Dept;

public interface DeptService {

    Dept create(Dept dept);

    void update(Dept dept);

    void delete(Long id);
}
