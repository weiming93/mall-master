package com.blueocean.mall.common;

import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


@UtilityClass
public class DateUtil {
    // 根据指定格式显示日期和时间
    /**
     * yyyy-MM-dd
     */
    private final DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    private final DateTimeFormatter yyyyMMddHHmmss = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取指定的日期
     * @param instant
     * @return yyyy-MM-dd
     */
    public String getDateByInstant(Instant instant){
        return yyyyMMdd.withZone(ZoneId.systemDefault()).format(instant);
    }


}
