package com.emond.mall.provider.payload.projection;


import com.emond.mall.common.jpa.projection.BaseProjection;

public interface DeptProjection extends BaseProjection {

    String getName();
    Boolean getEnabled();
    Long getPid();
    Long pid();
}
