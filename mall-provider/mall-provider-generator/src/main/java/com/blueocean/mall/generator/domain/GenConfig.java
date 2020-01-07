package com.blueocean.mall.generator.domain;

import com.blueocean.mall.common.domain.IdentityModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 代码生成配置
 * @author Zheng Jie
 * @date 2019-01-03
 */
@Data
@Entity
@Table(name = "gen_config")
public class GenConfig extends IdentityModel {

    // 作者
    private String author;

    // 是否覆盖
    private Boolean cover;

    // 模块名
    @Column(name = "module_name")
    private String moduleName;

    // 包路径
    private String pack;

    // 前端文件路径
    private String path;

    // 前端
    @Column(name = "api_path")
    private String apiPath;

    // 表前缀
    private String prefix;

}
