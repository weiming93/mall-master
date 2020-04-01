package com.emond.mall.provider.goods.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 分类筛选样式
 * @author: Chen Weiming
 */
@AllArgsConstructor
@Getter
public enum Style {
    NORMAL("普通"),
    COLOR("颜色");
    private String desc;
}
