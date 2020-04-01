package com.emond.mall.business.controller;

import com.emond.mall.business.domain.Attribute;
import com.emond.mall.business.mapper.AttributeMapper;
import com.emond.mall.business.query.AttributeQueryCriteria;
import com.emond.mall.business.service.AttributeService;
import com.emond.mall.common.domain.Create;
import com.emond.mall.common.domain.Update;
import com.emond.mall.provider.goods.dto.AttributeDTO;
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
@Api(tags = "商品属性REST")
@RestController
@RequestMapping("attribute")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AttributeController {

    private final AttributeService attributeService;

    private final AttributeMapper attributeMapper;

    @ApiOperation("分页查询商品属性")
    @GetMapping
    public Page<AttributeDTO> findPage(AttributeQueryCriteria criteria,
                                  Pageable pageable) {
        return attributeMapper.toPage(attributeService.findPage(criteria, pageable));
    }

    @ApiOperation("根据ID查询商品属性")
    @GetMapping("{id}")
    public AttributeDTO findById(@PathVariable Long id) {
        return attributeMapper.toDTO(attributeService.findById(id));
    }

    @ApiOperation("新增商品属性")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AttributeDTO create( @RequestBody @Validated(Create.class) Attribute resource) {
        return attributeMapper.toDTO(attributeService.create(resource));
    }

    @ApiOperation("更新商品属性")
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public AttributeDTO update(@Validated(Update.class) @RequestBody Attribute resource) {
        return attributeMapper.toDTO(attributeService.update(resource));
    }

    @ApiOperation("删除商品属性")
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@RequestBody Set<Long> ids) {
        attributeService.delete(ids);
    }

}
