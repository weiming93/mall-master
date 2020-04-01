package com.emond.mall.business.controller;

import com.emond.mall.business.domain.Parameter;
import com.emond.mall.business.mapper.ParameterMapper;
import com.emond.mall.business.query.ParameterQueryCriteria;
import com.emond.mall.business.service.ParameterService;
import com.emond.mall.common.domain.Create;
import com.emond.mall.common.domain.Update;
import com.emond.mall.provider.goods.dto.ParameterDTO;
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
 * @author Chen Weiming
 */
@Api(tags = "商品参数REST")
@RestController
@RequestMapping("parameter")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ParameterController {

    private final ParameterService parameterService;

    private final ParameterMapper parameterMapper;

    @ApiOperation("分页查询商品属性")
    @GetMapping
    public Page<ParameterDTO> findPage(ParameterQueryCriteria criteria,
                                  Pageable pageable) {
        return parameterMapper.toPage(parameterService.findPage(criteria, pageable));
    }

    @ApiOperation("根据ID查询商品属性")
    @GetMapping("{id}")
    public ParameterDTO findById(@PathVariable Long id) {
        return parameterMapper.toDTO(parameterService.findById(id));
    }

    @ApiOperation("新增商品属性")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParameterDTO create(@Validated(Create.class) @RequestBody Parameter resource) {
        return parameterMapper.toDTO(parameterService.create(resource));
    }

    @ApiOperation("更新商品属性")
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ParameterDTO update(@Validated(Update.class) @RequestBody Parameter resource) {
        return parameterMapper.toDTO(parameterService.update(resource));
    }

    @ApiOperation("删除商品属性")
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@RequestBody Set<Long> ids) {
        parameterService.delete(ids);
    }

}
