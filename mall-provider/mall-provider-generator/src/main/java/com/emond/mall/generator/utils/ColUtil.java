package com.emond.mall.generator.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Properties;

/**
 * sql字段转java
 *
 */
@UtilityClass
@Slf4j
public class ColUtil {

    private static class MyObjectHandler {
        private static Properties properties;
        static {
            try {
                log.info("加载配置类generator.properties");
                properties = PropertiesLoaderUtils.loadAllProperties("generator.properties");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Assert.notNull(properties,"generator.properties文件不存在");
        }

    }

    /**
     * 转换mysql数据类型为java数据类型
     * @param type 数据库字段类型
     * @return String
     */
    String cloToJava(String type){
        return MyObjectHandler.properties.getProperty(type,"unknowType");
    }

}
