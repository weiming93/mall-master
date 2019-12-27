package com.blueocean.mall.provider.repository;

import com.blueocean.mall.provider.model.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.springdata.jpa.repository.JpaSpecificationExecutorWithProjection;

public interface DeptRepository extends JpaRepository<Dept,Long>{
}
