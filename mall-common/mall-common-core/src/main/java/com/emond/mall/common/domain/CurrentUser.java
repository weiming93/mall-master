package com.emond.mall.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 登录用户
 * @author: Chen Weiming
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentUser implements Serializable {
    private static final long serialVersionUID = -8822181188126776301L;
    private Long id;
    private String username;
}
