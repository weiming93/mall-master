package com.emond.mall.common.utils;

import com.emond.mall.common.exception.MallCloudException;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Chen Weiming
 */
@UtilityClass
public class RegexpUtils {
    // 手机号正则
    public static final String MOBILE_REG = "[1]\\d{10}";
    // 邮箱号正则
    public static final String EMAIL_REG = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";

    /**
     * 正则校验
     *
     * @param regex 正则表达式字符串
     * @param value 要匹配的字符串
     * @return 正则校验结果
     */
    public static boolean match(String regex, String value) {
        if (StringUtils.isBlank(regex)){
            throw new MallCloudException("正则表达式字符串不能为空");
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    /**
     *
     * @param regex
     * @param value
     * @return 不匹配:true,匹配:false
     */
    public static boolean notMatch(String regex, String value){
        return !match(regex,value);
    }
}
