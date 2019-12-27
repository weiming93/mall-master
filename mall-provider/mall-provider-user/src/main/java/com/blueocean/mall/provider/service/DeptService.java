package com.blueocean.mall.provider.service;

import com.blueocean.mall.provider.model.Dept;
import com.blueocean.mall.provider.repository.projections.DeptProjection;

public interface DeptService {

    Dept create(Dept dept);

    void update(Dept dept);

    void delete(Long id);
}
