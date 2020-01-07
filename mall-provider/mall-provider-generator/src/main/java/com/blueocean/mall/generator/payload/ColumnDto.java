package com.blueocean.mall.generator.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 列的数据信息
 */
@Data
public class ColumnDto {

    // 数据库字段名称
    private String columnName;

    // 允许空值
    private String isNullable;

    // 数据库字段类型
    private String columnType;

    // 数据库字段注释
    private String columnComment;

    // 数据库字段键类型
    private String columnKey;

    // 额外的参数
    private String extra;

    // 查询 1:模糊 2：精确
    private ColumnQuery columnQuery;

    // 是否在列表显示
    private Boolean columnShow;

    @Getter
    @AllArgsConstructor
    enum ColumnQuery{
        FUZZY("模糊"),
        EXACT("精确"),
        ;
        private String desc;
    }
}
