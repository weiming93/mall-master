package com.emond.mall.provider.repository;

import com.emond.mall.provider.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.springdata.jpa.repository.JpaSpecificationExecutorWithProjection;

public interface DeptRepository extends JpaRepository<Dept,Long>, JpaSpecificationExecutorWithProjection {
}
