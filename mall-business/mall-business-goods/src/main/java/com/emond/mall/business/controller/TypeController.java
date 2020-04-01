package com.emond.mall.business.controller;

import com.emond.mall.business.domain.Type;
import com.emond.mall.business.mapper.TypeMapper;
import com.emond.mall.business.query.TypeQueryCriteria;
import com.emond.mall.business.service.TypeService;
import com.emond.mall.common.domain.Create;
import com.emond.mall.common.domain.ElTree;
import com.emond.mall.common.domain.Update;
import com.emond.mall.provider.goods.dto.TypeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @author Chen Weiming
 */
@Api(tags = "商品类型REST")
@RestController
@RequestMapping("type")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TypeController {

    private final TypeService typeService;

    private final TypeMapper typeMapper;

    @ApiOperation("分页查询商品类型")
    @GetMapping
    public Page<TypeDTO> findPage(TypeQueryCriteria criteria,
                                  Pageable pageable) {
        return typeMapper.toPage(typeService.findPage(criteria, pageable));
    }
    @ApiOperation("获取所有商品类型")
    @GetMapping("all")
    public List<TypeDTO> findAll() {
        return typeMapper.toDTO(typeService.findAll());
    }
    @ApiOperation("根据ID查询商品类型")
    @GetMapping("{id}")
    public TypeDTO findById(@PathVariable Long id) {
        return typeMapper.toDTO(typeService.findById(id));
    }

    @ApiOperation("新增商品类型")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TypeDTO create(@Validated(Create.class) @RequestBody Type resource) {
        return typeMapper.toDTO(typeService.create(resource));
    }

    @ApiOperation("更新商品类型")
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public TypeDTO update(@Validated(Update.class) @RequestBody Type resource) {
        return typeMapper.toDTO(typeService.update(resource));
    }

    @ApiOperation("删除商品类型")
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@RequestBody Set<Long> ids) {
        typeService.delete(ids);
    }

    @ApiOperation("获取级联属性")
    @GetMapping("cascaderAttribute")
    public List<ElTree> getCascaderAttribute(){
        return typeService.getCascaderAttribute();
    }

}
