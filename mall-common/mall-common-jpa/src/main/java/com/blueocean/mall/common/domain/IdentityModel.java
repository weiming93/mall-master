package com.blueocean.mall.common.domain;

import com.blueocean.mall.common.auditing.DateAudit;
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
    @NotNull(groups = Update.class)
    @Null(groups = Create.class)
    private Long id;

}
