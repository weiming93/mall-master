package com.emond.mall.business.query;

import com.emond.mall.common.annotation.Query;
import lombok.Data;

/**
 * @description:
 * @author: Chen Weiming
 */
@Data
public class BrandQueryCriteria {
    @Query(type = Query.Type.INNER_LIKE)
    private String name;
}
