package com.emond.mall.common.selector;

import com.emond.mall.common.config.AuthExceptionConfiguration;
import com.emond.mall.common.config.ServerProtectConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @description: 将自定义配置类注册到IOC容器
 * @author: Chen Weiming
 */
public class MallCloudApplicationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                AuthExceptionConfiguration.class.getName(),
                ServerProtectConfiguration.class.getName()
        };
    }
}
