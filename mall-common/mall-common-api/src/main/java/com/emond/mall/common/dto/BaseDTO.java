package com.emond.mall.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 *  DTO公共类
 * @author: Chen Weiming
 */
@Data
public class BaseDTO implements Serializable {
    private Long id;
    private Instant createdAt;
}
