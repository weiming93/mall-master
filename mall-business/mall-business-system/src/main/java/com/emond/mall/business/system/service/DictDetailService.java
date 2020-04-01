package com.emond.mall.business.system.service;

import com.emond.mall.business.system.domain.DictDetail;
import com.emond.mall.common.service.BaseService;

/**
 * @author: Chen Weiming
 */
public interface DictDetailService extends BaseService<DictDetail> {
    /**
     * 删除字典详情
     * @param id
     */
    void delete(Long id);

}
