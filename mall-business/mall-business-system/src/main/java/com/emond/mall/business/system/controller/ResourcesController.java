package com.emond.mall.business.system.controller;

import com.emond.mall.business.system.service.ResourcesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author: Chen Weiming
 */
@Api(tags = "资源管理")
@RestController
@RequestMapping("resources")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ResourcesController {

    private final ResourcesService resourcesService;
    @ApiOperation("资源上传")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String upload(@RequestParam MultipartFile file){
        return resourcesService.upload(file);
    }

}
