package com.emond.mall.provider.domain;

import com.emond.mall.common.jpa.domain.IdentityModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@EqualsAndHashCode(of = "id")
@Entity
@Tag(name = "品牌")
public class Brand extends IdentityModel {
    /**
     * 名牌名
     */
    @NotBlank
    private String name;

    /**
     * 品牌图片
     */
    @NotBlank
    private String image;

    /**
     * 品牌首字母
     */
    @NotBlank
    private String letter;

    /**
     * 排序
     */
    @NotNull
    private Integer seq;


}
