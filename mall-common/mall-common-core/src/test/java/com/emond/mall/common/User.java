package com.emond.mall.common;

import com.emond.mall.common.auditing.DateAudit;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class User extends DateAudit {
    @Id
    @GeneratedValue(generator = "idWorker")
    @GenericGenerator(name = "idWorker",strategy = "com.blueocean.mall.common.generated.SnowFlakeIdGenerator")
    private Long id;


}
