package com.emond.mall.common.formatter;

import com.emond.mall.common.utils.DateUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.Instant;

/**
 * 全局日期格式化
 * @author: Chen Weiming
 */
@JsonComponent
public class GlobalDateFormat {

    /**
     * 日期格式化
     */
    public static class DateJsonSerializer extends JsonSerializer<Instant> {
        @Override
        public void serialize(Instant instant, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            //格式化日期
            jsonGenerator.writeString(DateUtils.getDateTimeByInstant(instant));
        }
    }

    /**
     * 解析日期字符串
     */
    public static class DateJsonDeserializer extends JsonDeserializer<Instant> {
        @Override
        public Instant deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return DateUtils.parseDateTime(jsonParser.getText());
        }
    }
}
