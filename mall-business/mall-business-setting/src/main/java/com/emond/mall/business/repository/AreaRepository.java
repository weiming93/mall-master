package com.emond.mall.business.repository;

import com.emond.mall.business.domain.Area;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

/**
 * @author Chen Weiming
 */
public interface AreaRepository extends JpaRepositoryImplementation<Area,Long> {
    /**
     * 获取省市区
     * @param level
     * @return
     */
    List<Area> findByLevelLessThanEqualOrderByLevelAsc(Integer level);
}
