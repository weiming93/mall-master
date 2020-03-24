package com.emond.mall.business.system.domain.query;

import com.emond.mall.common.annotation.Query;
import lombok.Data;

/**
 * @description:
 * @author: Chen Weiming
 */
@Data
public class DictQueryCriteria {
    @Query(blurry = "name")
    private String blurry;
}
