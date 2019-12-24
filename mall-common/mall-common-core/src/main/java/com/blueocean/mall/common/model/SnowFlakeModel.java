package com.blueocean.mall.common.model;

import com.blueocean.mall.common.auditing.DateAudit;
import com.blueocean.mall.common.auditing.UserDateAudit;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class SnowFlakeModel extends DateAudit {
    @Id
    @GeneratedValue(generator = "idWorker")
    @GenericGenerator(name = "idWorker",strategy = "com.blueocean.mall.common.generated.SnowFlakeIdGenerator")
    private Long id;
}
