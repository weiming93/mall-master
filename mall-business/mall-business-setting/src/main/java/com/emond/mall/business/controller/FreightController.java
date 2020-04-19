package com.emond.mall.business.controller;

import com.emond.mall.business.domain.Freight;
import com.emond.mall.business.mapper.FreightMapper;
import com.emond.mall.business.service.FreightService;
import com.emond.mall.provider.setting.dto.FreightDTO;
import com.emond.mall.provider.setting.query.FreightQueryCriteria;
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
@Api(tags = "运费模板REST")
@RestController
@RequestMapping("freight")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FreightController {

    private final FreightService freightService;

    private final FreightMapper freightMapper;

    @ApiOperation("分页查询运费模板")
    @GetMapping
    public Page<FreightDTO> findPage(FreightQueryCriteria criteria,
                                     Pageable pageable) {
        return freightMapper.toPage(freightService.findPage(criteria, pageable));
    }

    @ApiOperation("根据ID查询运费模板")
    @GetMapping("{id}")
    public FreightDTO findById(@PathVariable Long id) {
        return freightMapper.toDTO(freightService.findById(id));
    }

    @ApiOperation("新增运费模板")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FreightDTO create(@Validated @RequestBody Freight resource) {
        return freightMapper.toDTO(freightService.create(resource));
    }

    @ApiOperation("更新运费模板")
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Validated @RequestBody Freight resource) {
         freightService.update(resource);
    }

    @ApiOperation("删除运费模板")
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@RequestBody Set<Long> ids) {
        freightService.delete(ids);
    }


}
