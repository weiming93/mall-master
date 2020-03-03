package com.emond.mall.provider.user.dto;

import com.emond.mall.provider.user.domain.MenuType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 菜单
 */
@Getter
@Setter
public class MenuDTO implements Serializable {

    private Long id;

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

    private Timestamp createTime;
}
