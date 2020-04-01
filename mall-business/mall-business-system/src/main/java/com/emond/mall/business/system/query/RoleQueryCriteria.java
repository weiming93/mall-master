package com.emond.mall.business.system.query;

import com.emond.mall.common.annotation.Query;
import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * @author: Chen Weiming
 */
@Data
public class RoleQueryCriteria {
    @Query(blurry = "name")
    private String name;

    @Query(type = Query.Type.BETWEEN)
    private List<Instant> createAt;
}
