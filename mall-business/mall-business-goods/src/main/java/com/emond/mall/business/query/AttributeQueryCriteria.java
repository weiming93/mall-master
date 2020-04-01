package com.emond.mall.business.query;

import com.emond.mall.common.annotation.Query;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Chen Weiming
 */
@Data
public class AttributeQueryCriteria implements Serializable {
    @Query(propName = "id", joinName = "type")
    private Long typeId;

    @Query(type = Query.Type.INNER_LIKE)
    private String name;
}
