package com.emond.mall.provider.setting.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 费用计算方式
 * @author: Chen Weiming
 */
@AllArgsConstructor
@Getter
public enum CostCalculation {
    WEIGHT("按重量计算"),
    PIECES("按商品件数计算");
    private String desc;
}
