package com.emond.mall.provider.goods.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 属性是否可选
 * @author: Chen Weiming
 */
@AllArgsConstructor
@Getter
public enum Selected {
    ONLY("唯一属性"),
    SINGLE("单选属性"),
    MULTIPLE("多选属性");
    private String desc;
}
