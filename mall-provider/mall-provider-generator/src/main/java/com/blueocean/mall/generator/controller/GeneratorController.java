package com.blueocean.mall.generator.controller;

import com.blueocean.mall.common.exception.BadRequestException;
import com.blueocean.mall.generator.domain.GenConfig;
import com.blueocean.mall.generator.payload.ColumnDto;
import com.blueocean.mall.generator.payload.ColumnProjection;
import com.blueocean.mall.generator.payload.TableProjection;
import com.blueocean.mall.generator.service.GeneratorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "系统：代码生成")
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    @Value("${generator.enabled}")
    private Boolean generatorEnabled;

    @Operation(summary = "查询生成器配置管理")
    @GetMapping("/genConfig")
    @ResponseStatus(HttpStatus.OK)
    public GenConfig getGenConfig() {
        return generatorService.find();
    }

    @Operation(summary = "更新生成器配置管理")
    @PutMapping("/genConfig")
    @ResponseStatus(HttpStatus.OK)
    public GenConfig updateGenConfig(@Valid @RequestBody GenConfig genConfig) {
        return generatorService.update(genConfig);
    }

    @Operation(summary = "查询数据库元数据")
    @GetMapping("/tables")
    @ResponseStatus(HttpStatus.OK)
    public Page<TableProjection> getTables(@RequestParam String tableName,
                                           @RequestParam Pageable pageable) {
        return generatorService.findPagedTableProjectedByTableName(tableName, pageable);
    }

    @Operation(summary = "查询表内元数据")
    @GetMapping("/columns")
    @ResponseStatus(HttpStatus.OK)
    public List<ColumnProjection> getColumns(@RequestParam String tableName) {
        return generatorService.findColumnProjectionsByTableName(tableName);
    }

    @Operation(summary = "生成代码")
    @PostMapping("/generate")
    @ResponseStatus(HttpStatus.CREATED)
    public void generate(@RequestBody List<ColumnDto> columnDtos, @RequestParam String tableName){
        if(!generatorEnabled){
            throw new BadRequestException("此环境不允许生成代码！");
        }
        generatorService.generate(columnDtos,generatorService.find(),tableName);
    }
}
