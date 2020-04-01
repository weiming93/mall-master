package com.emond.mall.provider.goods.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 能否进行检索
 * @author: Chen Weiming
 */
@AllArgsConstructor
@Getter
public enum Searching {
    NONE("不需要检索"),
    KEY("关键字检索");
    private String desc;
}
