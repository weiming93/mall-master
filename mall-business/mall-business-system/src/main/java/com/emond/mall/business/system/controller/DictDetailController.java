package com.emond.mall.business.system.controller;

import com.emond.mall.business.system.domain.DictDetail;
import com.emond.mall.business.system.query.DictDetailQueryCriteria;
import com.emond.mall.business.system.mapper.DictDetailMapper;
import com.emond.mall.business.system.service.DictDetailService;
import com.emond.mall.common.domain.Create;
import com.emond.mall.common.domain.Update;
import com.emond.mall.provider.system.dto.DictDetailDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Chen Weiming
 */
@Api(tags = "字典详情管理")
@RestController
@RequestMapping("dictDetail")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictDetailController {

    private final DictDetailService dictDetailService;

    private final DictDetailMapper dictDetailMapper;

    @ApiOperation("查询分页字典详情")
    @GetMapping
    public Page<DictDetailDTO> getPage(DictDetailQueryCriteria criteria,
                                       @PageableDefault(sort = {"sort"}, direction = Sort.Direction.ASC)Pageable pageable){
        return dictDetailMapper.toPage(dictDetailService.findPage(criteria,pageable));
    }




    @ApiOperation("新增字典详情")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DictDetailDTO create(@Validated(Create.class) @RequestBody DictDetail resources){
      return dictDetailMapper.toDTO(dictDetailService.create(resources));
    }

    @ApiOperation("修改字典详情")
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Validated(Update.class) @RequestBody DictDetail resources){
        dictDetailService.update(resources);
    }

    @ApiOperation("删除字典详情")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        dictDetailService.delete(id);
    }
}
