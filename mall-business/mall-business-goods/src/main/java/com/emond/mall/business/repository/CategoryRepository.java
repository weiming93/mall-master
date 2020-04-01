package com.emond.mall.business.repository;

import com.emond.mall.business.domain.Category;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

/**
 * @author: Chen Weiming
 */
public interface CategoryRepository extends JpaRepositoryImplementation<Category,Long> {
    List<Category> findByPid(Long pid);
}
