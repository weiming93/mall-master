package com.emond.mall.common.domain;


import com.emond.mall.common.auditing.DateAudit;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Data
public abstract class SnowFlakeModel extends DateAudit {
    @Id
    @GeneratedValue(generator = "idWorker")
    @GenericGenerator(name = "idWorker",strategy = "com.blueocean.mall.common.generated.SnowFlakeIdGenerator")
    @NotNull(groups = Update.class)
    private Long id;
}
