package com.emond.mall.business.system.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author: Chen Weiming
 */
public interface ResourcesService {


    String upload(MultipartFile file);

}
