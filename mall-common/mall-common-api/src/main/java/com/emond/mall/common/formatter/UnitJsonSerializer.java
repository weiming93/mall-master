package com.emond.mall.common.formatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author: Chen Weiming
 */
public class UnitJsonSerializer  extends JsonSerializer<Number> {
    private Double unit;

    public UnitJsonSerializer(Double unit) {
        this.unit = unit;
    }

    @Override
    public void serialize(Number number, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        double v = number.longValue() / unit;
        jsonGenerator.writeString(String.valueOf(v));
    }
}
