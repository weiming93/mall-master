package com.emond.mall.business.controller;

import com.emond.mall.business.service.AreaService;
import com.emond.mall.common.domain.ElTree;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Chen Weiming
 */
@Api(tags = "地区REST")
@RestController
@RequestMapping("area")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AreaController {
    private final AreaService areaService;
    @ApiOperation("获取省市区树状结构")
    @GetMapping("provinceAndCityAndArea")
    public List<ElTree> findProvinceAndCityAndArea(){
        return areaService.findProvinceAndCityAndArea();
    }
    @ApiOperation("获取省市树状结构")
    @GetMapping("provinceAndCity")
    public List<ElTree> findProvinceAndCity(){
        return areaService.findProvinceAndCity();
    }

    @ApiOperation("获取省树状结构")
    @GetMapping("province")
    public List<ElTree> findProvince(){
        return areaService.findProvince();
    }
}
