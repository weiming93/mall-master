package com.emond.mall.common.utils;

import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;


@UtilityClass
public class DateUtils {
    /**
     * 时区
     */
    private final String TIMEZONE = "Asia/Shanghai";
    /**
     * yyyy-MM-dd
     */
    private final DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of(TIMEZONE));

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    private final DateTimeFormatter yyyyMMddHHmmss = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of(TIMEZONE));



    /**
     * 获取指定的日期
     *
     * @param instant
     * @return yyyy-MM-dd
     */
    public static String getDateByInstant(Instant instant) {
        return yyyyMMdd.format(instant);
    }

    /**
     * 获取指定的日期
     *
     * @param instant
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getDateTimeByInstant(Instant instant) {
        return yyyyMMddHHmmss.format(instant);
    }

    /**
     * 字符串转日期
     * @param dateTime
     * @return
     */
    public static Instant parseDateTime(String dateTime){
        TemporalAccessor accessor = yyyyMMddHHmmss.parse(dateTime);
        return Instant.from(accessor);
    }



}
