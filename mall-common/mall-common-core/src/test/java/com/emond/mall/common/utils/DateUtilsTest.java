package com.emond.mall.common.utils;


import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: Chen Weiming
 */
public class DateUtilsTest {
    @Test
    public void givenInstantThenDateTime(){
        String dateTime = "2020-01-01 00:00:00";
        Instant instant = DateUtils.parseDateTime(dateTime);
        assertEquals(dateTime,DateUtils.getDateTimeByInstant(instant));
    }
}
