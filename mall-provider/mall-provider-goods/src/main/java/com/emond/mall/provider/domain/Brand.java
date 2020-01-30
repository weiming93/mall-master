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
    @NotBlank
    @Column(unique = true, columnDefinition = "COMMENT '名牌名'")
    private String name;

    @NotBlank
    @Column(columnDefinition = "COMMENT '品牌图片'")
    private String image;

    @NotBlank
    @Column(columnDefinition = "COMMENT '品牌首字母'")
    private String letter;

    @NotNull
    @Column(columnDefinition = "COMMENT '排序'")
    private Integer seq;


}
