package com.emond.mall.provider.setting.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 地区级别
 * @author: Chen Weiming
 */
@AllArgsConstructor
@Getter
public enum AreaLevel {
    PROVINCE(1,"省"),
    CITY(2,"市"),
    AREA(3,"区"),
    STREET(4,"街道");
    private Integer level;
    private String desc;
}
