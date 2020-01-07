package com.blueocean.mall.generator.payload;

import java.time.Instant;

public interface TableProjection {
    // 获取表名称
    String getTableName();

    // 表创建时间
    Instant getCreateTime();

    // 数据库引擎
    String getEngine();

    //编码集
    String getTableCollation();

    // 备注
    String getTableComment();

}
