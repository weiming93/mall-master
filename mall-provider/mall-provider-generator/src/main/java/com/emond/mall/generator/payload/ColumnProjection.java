package com.emond.mall.generator.payload;


import com.emond.mall.common.jpa.projection.BaseProjection;

public interface ColumnProjection extends BaseProjection {
    // 数据库字段名称
    Object getColumnName();

    // 允许空值
    Object getIsNullable();

    // 数据库字段类型
    Object getColumnType();

    // 数据库字段注释
    Object getColumnComment();

    // 数据库字段键类型
    Object getColumnKey();

    // 额外的参数
    Object getExtra();

}
