package com.emond.mall.business.user.payload.projection;


import com.emond.mall.common.jpa.projection.BaseProjection;

public interface DeptProjection extends BaseProjection {

    String getName();
    Boolean getEnabled();
    Long getPid();
    Long pid();
}