package com.blueocean.mall.provider.repository.projections;

import com.blueocean.mall.common.projections.BaseProjection;

public interface DeptProjection extends BaseProjection {

    String getName();
    Boolean getEnabled();
    Long getPid();
    Long pid();
}
