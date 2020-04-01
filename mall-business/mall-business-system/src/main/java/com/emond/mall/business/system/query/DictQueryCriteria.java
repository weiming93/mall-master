package com.emond.mall.business.system.query;

import com.emond.mall.common.annotation.Query;
import lombok.Data;

/**
 * @author: Chen Weiming
 */
@Data
public class DictQueryCriteria {
    @Query(blurry = "name")
    private String blurry;
}
