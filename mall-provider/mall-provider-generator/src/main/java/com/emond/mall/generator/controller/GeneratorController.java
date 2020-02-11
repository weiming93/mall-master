package com.emond.mall.generator.controller;

import com.emond.mall.common.exception.BadRequestException;
import com.emond.mall.generator.domain.GenConfig;
import com.emond.mall.generator.payload.ColumnDto;
import com.emond.mall.generator.payload.ColumnProjection;
import com.emond.mall.generator.payload.TableProjection;
import com.emond.mall.generator.service.GeneratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/generator")
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    @Value("${generator.enabled}")
    private Boolean generatorEnabled;

    /**
     * 查询生成器配置管理
     * @return
     */
    @GetMapping("/genConfig")
    @ResponseStatus(HttpStatus.OK)
    public GenConfig getGenConfig() {
        return generatorService.find();
    }

    /**
     * 查询生成器配置管理
     * @param genConfig
     * @return
     */
    @PutMapping("/genConfig")
    @ResponseStatus(HttpStatus.OK)
    public GenConfig updateGenConfig(@Valid @RequestBody GenConfig genConfig) {
        return generatorService.update(genConfig);
    }

    /**
     * 查询数据库元数据
     * @param tableName
     * @param pageable
     * @return
     */
    @GetMapping("/tables")
    @ResponseStatus(HttpStatus.OK)
    public Page<TableProjection> getTables(@RequestParam String tableName,
                                           @RequestParam Pageable pageable) {
        return generatorService.findPagedTableProjectedByTableName(tableName, pageable);
    }

    /**
     * 查询表内元数据
      * @param tableName
     * @return
     */
    @GetMapping("/columns")
    @ResponseStatus(HttpStatus.OK)
    public List<ColumnProjection> getColumns(@RequestParam String tableName) {
        return generatorService.findColumnProjectionsByTableName(tableName);
    }

    /**
     * 生成代码
     * @param columnDtos
     * @param tableName
     */
    @PostMapping("/generate")
    @ResponseStatus(HttpStatus.CREATED)
    public void generate(@RequestBody List<ColumnDto> columnDtos, @RequestParam String tableName){
        if(!generatorEnabled){
            throw new BadRequestException("此环境不允许生成代码！");
        }
        generatorService.generate(columnDtos,generatorService.find(),tableName);
    }
}
