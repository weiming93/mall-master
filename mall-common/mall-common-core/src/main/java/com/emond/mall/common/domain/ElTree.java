package com.emond.mall.common.domain;

import lombok.Data;

import java.util.List;

/**
 * @description: el-tree 树形控件
 * @author: Chen Weiming
 */
@Data
public class ElTree {
    private Long id;
    private String label;
    private List<ElTree> children;
}
