package com.emond.mall.provider.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 菜单类型枚举
 * @author: Emond Chan
 */
@AllArgsConstructor
@Getter
public enum MenuType {
    CATALOGUE("目录"),
    MENU("菜单"),
    BUTTON("按钮");
    private String desc;
}
