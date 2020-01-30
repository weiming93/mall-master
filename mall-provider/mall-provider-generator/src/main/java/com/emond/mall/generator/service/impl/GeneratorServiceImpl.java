package com.emond.mall.generator.service.impl;


import com.emond.mall.common.exception.BadRequestException;
import com.emond.mall.generator.repository.GeneratorRepository;
import com.emond.mall.generator.domain.GenConfig;
import com.emond.mall.generator.payload.ColumnDto;
import com.emond.mall.generator.payload.ColumnProjection;
import com.emond.mall.generator.payload.TableProjection;
import com.emond.mall.generator.service.GeneratorService;
import com.emond.mall.generator.utils.GenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class GeneratorServiceImpl implements GeneratorService {
    @Autowired
    private GeneratorRepository genConfigRepository;

    @Override
    public GenConfig find() {
        Optional<GenConfig> genConfig = genConfigRepository.findById(1L);
        return genConfig.orElseGet(GenConfig::new);
    }

    @Override
    public GenConfig update(GenConfig genConfig) {
        genConfig.setId(1L);
        // 自动设置Api路径，注释掉前需要同步取消前端的注释
        String separator = File.separator;
        String[] paths;
        if (separator.equals("\\")) {
            paths = genConfig.getPath().split("\\\\");
        } else paths = genConfig.getPath().split(File.separator);
        StringBuilder api = new StringBuilder();
        for (String path : paths) {
            api.append(path);
            api.append(separator);
            if (path.equals("src")) {
                api.append("api");
                break;
            }
        }
        genConfig.setApiPath(api.toString());
        return genConfigRepository.save(genConfig);
    }

    @Override
    public GenConfig create(GenConfig genConfig) {
        return genConfigRepository.save(genConfig);
    }

    @Override
    public Page<TableProjection> findPagedTableProjectedByTableName(String tableName, Pageable pageable) {
        return genConfigRepository.findPagedTableProjectedByTableName(tableName,pageable);
    }

    @Override
    public List<ColumnProjection> findColumnProjectionsByTableName(String tableName) {
        return genConfigRepository.findColumnProjectionsByTableName(tableName);
    }

    @Override
    public void generate(List<ColumnDto> columnDtos, GenConfig genConfig, String tableName) {
        if(genConfig.getId() == null){
            throw new BadRequestException("请先配置生成器");
        }
        try {
            GenUtil.generatorCode(columnDtos,genConfig,tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
