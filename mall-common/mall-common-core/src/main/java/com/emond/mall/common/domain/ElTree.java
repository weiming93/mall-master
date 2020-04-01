package com.emond.mall.common.domain;

import lombok.*;

import java.util.List;

/**
 * el-tree 树形控件
 * @author: Chen Weiming
 */
@Data
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ElTree {
    @NonNull
    private Long id;
    @NonNull
    private String label;
    private List<ElTree> children;
}
