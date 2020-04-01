package com.emond.mall.business.system.service;


import com.emond.mall.business.system.domain.User;
import com.emond.mall.common.service.BaseService;
import com.emond.mall.provider.system.dto.UserPassDTO;

/**
 * @author Chen Weiming
 */
public interface UserService extends BaseService<User> {
    /**
     * 修改密码
     * @param userPassDTO
     */
    void updatePass(UserPassDTO userPassDTO);

    /**
     * 更新用户
     * @param resources
     */
    void updateProfile(User resources);
}
