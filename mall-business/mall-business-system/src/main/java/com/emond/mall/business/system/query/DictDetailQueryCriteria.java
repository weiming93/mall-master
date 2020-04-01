package com.emond.mall.business.system.query;

import com.emond.mall.common.annotation.Query;
import lombok.Data;

/**
 * @author: Chen Weiming
 */
@Data
public class DictDetailQueryCriteria {
    @Query(type = Query.Type.INNER_LIKE)
    private String label;

    @Query(propName = "name",joinName = "dict")
    private String dictName;
}
