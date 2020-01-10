package com.blueocean.mall.provider.payload.projection;


import com.blueocean.mall.common.jpa.projection.BaseProjection;

public interface DeptProjection extends BaseProjection {

    String getName();
    Boolean getEnabled();
    Long getPid();
    Long pid();
}
