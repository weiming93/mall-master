package com.emond.mall.generator.service;


import com.emond.mall.generator.domain.GenConfig;
import com.emond.mall.generator.payload.ColumnDto;
import com.emond.mall.generator.payload.ColumnProjection;
import com.emond.mall.generator.payload.TableProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface GeneratorService {

    GenConfig find();

    GenConfig update(GenConfig genConfig);

    GenConfig create(GenConfig genConfig);

    /**
     * @param tableName 表名
     * @param pageable 分页参数
     * @return 数据库元数据
     */
    Page<TableProjection> findPagedTableProjectedByTableName(String tableName, Pageable pageable);

    /**
     * @param tableName 表名
     * @return  数据表的元数据
     */
    List<ColumnProjection> findColumnProjectionsByTableName(String tableName);

    /**
     * 生成代码
     * @param columnDtos 表字段数据
     * @param genConfig 代码生成配置
     * @param tableName 表名
     */
    void generate(List<ColumnDto> columnDtos, GenConfig genConfig, String tableName);
}
