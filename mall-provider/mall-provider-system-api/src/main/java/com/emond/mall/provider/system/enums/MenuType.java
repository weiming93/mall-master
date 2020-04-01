package com.emond.mall.provider.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 菜单类型枚举
 * @author: Chen Weiming
 */
@AllArgsConstructor
@Getter
public enum MenuType {
    CATALOGUE("目录"),
    MENU("菜单"),
    BUTTON("按钮");
    private String desc;
}
