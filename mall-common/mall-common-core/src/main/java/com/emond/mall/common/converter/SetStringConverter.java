package com.emond.mall.common.converter;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Set,String转换器
 * @author: Chen Weiming
 */
public class SetStringConverter implements AttributeConverter<Set<String>, String> {


    /**
     * 集合转字符串，逗号拼接
     *
     * @param strings
     * @return
     */
    @Override
    public String convertToDatabaseColumn(Set<String> strings) {
        if (ObjectUtils.isNotEmpty(strings)) {
            return StringUtils.join(strings.toArray(), ",");
        }
        return null;
    }

    /**
     * 字符串转集合，逗号分隔
     * @param s
     * @return
     */
    @Override
    public Set<String> convertToEntityAttribute(String s) {
        if (StringUtils.isNotBlank(s)) {
            String[] split = StringUtils.split(s, ",");
            return Arrays.stream(split).collect(Collectors.toSet());
        }
        return null;
    }
}
