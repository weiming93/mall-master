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
@JsonSerialize(using = AmountUnitJsonFormat.AmountUnitJsonSerializer.class)
@JsonDeserialize(using = AmountUnitJsonFormat.AmountUnitJsonDeserializer.class)
public @interface AmountUnitJsonFormat {

    /**
     * 元 序列化为 分
     */
    public static class AmountUnitJsonSerializer extends UnitJsonSerializer {
        public AmountUnitJsonSerializer() {
            super(100d);
        }
    }

    /**
     * 分 反序列化为 元
     */
    public static class AmountUnitJsonDeserializer extends UnitJsonDeserializer {
        public AmountUnitJsonDeserializer() {
            super(100d);
        }
    }
}
