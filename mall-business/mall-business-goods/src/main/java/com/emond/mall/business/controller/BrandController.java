package com.emond.mall.business.controller;

import com.emond.mall.business.domain.Brand;
import com.emond.mall.business.mapper.BrandMapper;
import com.emond.mall.business.query.BrandQueryCriteria;
import com.emond.mall.business.service.BrandService;
import com.emond.mall.common.domain.Create;
import com.emond.mall.common.domain.Update;
import com.emond.mall.provider.goods.dto.BrandDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Api(tags = "品牌REST")
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandMapper brandMapper;

    @ApiOperation("分页查询品牌")
    @GetMapping
    public Page<BrandDTO> findPage(BrandQueryCriteria criteria,
                                   Pageable pageable) {
        return brandMapper.toPage(brandService.findPage(criteria, pageable));
    }

    @ApiOperation("根据ID查询品牌")
    @GetMapping("{id}")
    public BrandDTO findById(@PathVariable Long id) {
        return brandMapper.toDTO(brandService.findById(id));
    }

    @ApiOperation("新增品牌")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BrandDTO create(@Validated(Create.class) @RequestBody Brand resource) {
        return brandMapper.toDTO(brandService.create(resource));
    }

    @ApiOperation("更新品牌")
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Validated(Update.class) @RequestBody Brand resource) {
        brandService.update(resource);
    }

    @ApiOperation("删除品牌")
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@RequestBody Set<Long> ids) {
        brandService.delete(ids);
    }

}
