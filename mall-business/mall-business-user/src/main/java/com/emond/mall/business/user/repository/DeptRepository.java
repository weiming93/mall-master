package com.emond.mall.business.user.repository;

import com.emond.mall.provider.user.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept,Long> {
}
