package com.emond.mall.business.controller;

import com.emond.mall.business.domain.Category;
import com.emond.mall.business.mapper.CategoryMapper;
import com.emond.mall.business.query.CategoryQueryCriteria;
import com.emond.mall.business.service.CategoryService;
import com.emond.mall.provider.goods.dto.CategoryDTO;
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
 * @author: Chen Weiming
 */
@Api(tags = "商品分类REST")
@RestController
@RequestMapping("category")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;
    @ApiOperation("分页查询商品分类")
    @GetMapping
    public Page<CategoryDTO> findPage(CategoryQueryCriteria criteria,
                                      Pageable pageable) {
        return categoryMapper.toPage(categoryService.findPage(criteria, pageable));
    }

    @ApiOperation("根据ID查询商品分类")
    @GetMapping("{id}")
    public CategoryDTO findById(@PathVariable Long id) {
        return categoryMapper.toDTO(categoryService.findById(id));
    }

    @ApiOperation("新增商品分类")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO create(@Validated @RequestBody Category resource) {
        return categoryMapper.toDTO(categoryService.create(resource));
    }

    @ApiOperation("更新商品分类")
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Validated @RequestBody Category resource) {
        categoryService.update(resource);
    }

    @ApiOperation("删除商品分类")
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@RequestBody Set<Long> ids) {
        categoryService.delete(ids);
    }

    @ApiOperation("获取一级分类")
    @GetMapping("firstLevel")
    public List<CategoryDTO> firstLevel(){
        return categoryMapper.toDTO(categoryService.findFirstLevel());
    }
}
