package com.emond.mall.common.formatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * @author: Chen Weiming
 */
public class UnitJsonDeserializer extends JsonDeserializer<Number> {
    private Double unit;

    public UnitJsonDeserializer(Double unit) {
        this.unit = unit;
    }

    @Override
    public Number deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        String text = jsonParser.getText();
        NumberFormat format = NumberFormat.getInstance();
        Number number = null;
        try {
            number = format.parse(text);
        } catch (ParseException e) {
            throw new RuntimeException(text + "不是数字",e);
        }
        Double v = number.doubleValue() * unit;
        return v.longValue();
    }
}
