package com.emond.mall.common.formatter;

/**
 * @author: Chen Weiming
 */

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@JacksonAnnotationsInside
@JsonSerialize(using = WeightUnitJsonFormat.WeightUnitJsonSerializer.class)
@JsonDeserialize(using = WeightUnitJsonFormat.WeightUnitJsonDeserializer.class)
public @interface WeightUnitJsonFormat {

    /**
     *  序列化为 g
     */
    public static class WeightUnitJsonSerializer extends UnitJsonSerializer {
        public WeightUnitJsonSerializer() {
            super(1000d);
        }
    }

    /**
     * 分 反序列化为 元
     */
    public static class WeightUnitJsonDeserializer extends UnitJsonDeserializer {
        public WeightUnitJsonDeserializer() {
            super(1000d);
        }
    }
}
