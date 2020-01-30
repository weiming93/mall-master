package com.emond.mall.generator.payload;

import lombok.Data;

import java.time.Instant;

/**
 * 表的数据信息
 */
@Data
public class TableDto {

    // 表名称
    private String tableName;

    // 创建日期
    private Instant createTime;

    // 数据库引擎
    private String engine;

    // 编码集
    private String tableCollation;

    // 备注
    private String tableComment;


}
