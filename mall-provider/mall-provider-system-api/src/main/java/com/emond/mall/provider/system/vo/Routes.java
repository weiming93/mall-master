package com.emond.mall.provider.system.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * vue-router对应的实体类
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Routes implements Serializable {

    private String name;

    private String path;

    private Boolean hidden;

    private String redirect;

    private String component;

    private Boolean alwaysShow;

    private MenuMetaVo meta;

    private List<Routes> children;
}
