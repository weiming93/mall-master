package com.emond.mall.business.system.service;


import com.emond.mall.business.system.domain.User;
import com.emond.mall.business.system.domain.UserAvatar;
import com.emond.mall.business.system.domain.UserProfile;
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
     * 个人中心更新
     * @param resources
     */
    void updateProfile(UserProfile resources);

    /**
     * 更新头像
     * @param resource
     */
    void updateAvatar(UserAvatar resource);
}
