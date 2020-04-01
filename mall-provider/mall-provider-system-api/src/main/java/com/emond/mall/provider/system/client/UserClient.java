package com.emond.mall.provider.system.client;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: Chen Weiming
 */
@FeignClient(name = "mall-business-system")
public interface UserClient {

}
