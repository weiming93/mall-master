package com.emond.mall.business.system.query;

import com.emond.mall.common.annotation.Query;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * @author: Chen Weiming
 */
public class UserQueryCriteria implements Serializable {

    @Query
    private Long id;

    @Query(blurry = "email,username,phone")
    private String blurry;

    @Query
    private Boolean enabled;


    @Query(type = Query.Type.BETWEEN)
    private List<Instant> createAt;
}
