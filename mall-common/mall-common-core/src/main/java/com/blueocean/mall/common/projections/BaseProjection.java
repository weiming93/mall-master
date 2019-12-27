package com.blueocean.mall.common.projections;

import java.time.Instant;

/**
 * 基础投影类
 */
public interface BaseProjection {
    Long getId();
    Instant getCreatedAt();
    Instant getUpdatedAt();
}
