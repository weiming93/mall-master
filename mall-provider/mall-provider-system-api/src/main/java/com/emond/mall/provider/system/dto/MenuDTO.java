package com.emond.mall.provider.system.dto;

import com.emond.mall.common.dto.BaseDTO;
import com.emond.mall.provider.system.enums.MenuType;
import lombok.Data;

import java.util.List;


@Data
public class MenuDTO extends BaseDTO {


    private MenuType type;

    private String permission;

    private String name;

    private Long sort;

    private String path;

    private String component;

    private Long pid;

    private Boolean iFrame;

    private Boolean cache;

    private Boolean hidden;

    private String componentName;

    private String icon;

    private List<MenuDTO> children;

}
