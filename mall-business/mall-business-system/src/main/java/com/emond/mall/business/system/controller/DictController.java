package com.emond.mall.business.system.controller;

import com.emond.mall.business.system.domain.Dict;
import com.emond.mall.business.system.query.DictQueryCriteria;
import com.emond.mall.business.system.mapper.DictMapper;
import com.emond.mall.business.system.service.DictService;
import com.emond.mall.common.domain.Create;
import com.emond.mall.common.domain.Update;
import com.emond.mall.provider.system.dto.DictDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author: Chen Weiming
 */
@Api(tags = "字典管理")
@RestController
@RequestMapping("dict")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictController {

    private final DictService dictService;

    private final DictMapper dictMapper;

    @ApiOperation("查询分页字典")
    @GetMapping
    public Page<DictDTO> getDictPage(DictQueryCriteria criteria, Pageable pageable){
        return dictMapper.toPage(dictService.findPage(criteria,pageable));
    }


    @ApiOperation("新增字典")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DictDTO create(@Validated @RequestBody Dict resources){
      return dictMapper.toDTO(dictService.create(resources));
    }

    @ApiOperation("修改字典")
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Validated @RequestBody Dict resources){
        dictService.update(resources);
    }

    @ApiOperation("删除字典")
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Set<Long> ids){
        dictService.delete(ids);
    }
}
