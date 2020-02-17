package com.emond.mall.generator.repository;

import com.emond.mall.generator.domain.GenConfig;
import com.emond.mall.generator.payload.ColumnProjection;
import com.emond.mall.generator.payload.TableProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface GeneratorRepository extends JpaRepository<GenConfig,Long> {

    @Query(
            value = "select table_name AS tableName ,create_time AS createTime , engine, table_collation AS tableCollation, table_comment AS tableComment from information_schema.tables " +
                    "where table_schema = (select database()) and if(:tableName!='',table_name LIKE CONCAT('%',:tableName,'%'),1=1) ",
            countQuery = "SELECT COUNT(*) from information_schema.tables " +
                    "where table_schema = (select database()) and if(:tableName!='',table_name LIKE CONCAT('%',:tableName,'%'),1=1)  ",
            nativeQuery = true)
    Page<TableProjection> findPagedTableProjectedByTableName(@Param("tableName") String tableName, Pageable pageable);


    @Query(
            value = "select column_name AS columnName, is_nullable AS isNullable, data_type AS dateType, " +
                    "column_comment AS columnComment, column_key AS columnKey, extra from information_schema.columns " +
                    "where table_schema = (select database()) and if(:tableName!='',table_name LIKE CONCAT('%',:tableName,'%'),1=1) order by ordinal_position",
            nativeQuery = true)
    List<ColumnProjection> findColumnProjectionsByTableName(@Param("tableName") String tableName);
}
