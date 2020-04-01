package com.emond.mall.business.query;

import com.emond.mall.common.annotation.Query;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Chen Weiming
 */
@Data
public class BrandQueryCriteria implements Serializable {
    @Query(type = Query.Type.INNER_LIKE)
    private String name;
}
