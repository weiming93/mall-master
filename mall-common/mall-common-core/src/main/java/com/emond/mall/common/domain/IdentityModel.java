package com.emond.mall.common.domain;

import com.emond.mall.common.auditing.DateAudit;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@MappedSuperclass
@Data
public abstract class IdentityModel extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = Update.class, message = "{required}")
    @Null(groups = Create.class, message = "不为空")
    private Long id;

}
