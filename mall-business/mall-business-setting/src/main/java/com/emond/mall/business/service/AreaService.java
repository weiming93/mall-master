package com.emond.mall.business.service;

import com.emond.mall.business.domain.Area;
import com.emond.mall.common.domain.ElTree;
import com.emond.mall.common.service.BaseService;

import java.util.List;

/**
 * @author Chen Weiming
 */
public interface AreaService extends BaseService<Area> {
    /**
     * 获取省市区树状结构
     * @return
     */
    List<ElTree> findProvinceAndCityAndArea();

    /**
     * 获取省市树状结构
     * @return
     */
    List<ElTree> findProvinceAndCity();

    /**
     * 获取省树状结构
     * @return
     */
    List<ElTree> findProvince();

}
