package com.emond.mall.business.controller;

import com.emond.mall.business.service.BrandService;
import com.emond.mall.common.jpa.domain.Create;
import com.emond.mall.common.jpa.domain.Update;
import com.emond.mall.provider.domain.Brand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Tag(name="品牌REST")
@RestController
@RequestMapping("goods/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Operation(summary = "查询全部品牌")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Brand> findAll(){
        return brandService.findAll();
    }

    @Operation(summary = "分页查询品牌")
    @GetMapping("page")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Page<Brand>> findPage(Pageable pageable){
        return brandService.findPage(pageable);
    }

    @Operation(summary = "根据ID查询品牌")
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Brand> findById(@PathVariable Long id){
        return brandService.findById(id);
    }

    @Operation(summary = "新增品牌")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Brand> save(@Validated(Create.class) @RequestBody Brand brand){
        return brandService.save(brand);
    }

    @Operation(summary = "更新品牌")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<Brand> update(@Validated(Update.class) @RequestBody Brand brand){
        return brandService.update(brand);
    }

    @Operation(summary = "删除品牌")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id){
         brandService.deleteById(id);
    }

}
