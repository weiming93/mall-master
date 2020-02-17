package com.emond.mall.common;

import com.google.common.base.CaseFormat;
import com.google.common.base.Splitter;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class MallStringUtils {

    /**
     * @return toCapitalizeCamelCase("hello_world") == "HelloWorld"
     */
    public String toCapitalizeCamelCase(String s) {
        if (StringUtils.isBlank(s)){
            return "";
        }
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL,s);
    }

    /**
     * @return toCamelCase(" hello_world ") == "helloWorld"
     */
    public String toCamelCase(String s) {
        if (StringUtils.isBlank(s)){
            return "";
        }
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,s);
    }
    /**
     * @return toUnderScoreCase("helloWorld") = "hello_world"
     */
    public String toUnderScoreCase(String s){
        if (StringUtils.isBlank(s)){
            return "";
        }
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,s);
    }



}
