package com.emond.mall.common;

import com.google.common.base.CaseFormat;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils{


    /**
     *
     * @return s == null || string.isEmpty() 返回 true
     */
    public boolean isBlank(String s){
        return s == null || s.isEmpty();
    }

    /**
     *
     * @return s != null && !string.isEmpty() 返回 true
     */
    public boolean isNotBlank(String s){
        return !isBlank(s);
    }
    /**
     * @return toCapitalizeCamelCase("hello_world") == "HelloWorld"
     */
    public String toCapitalizeCamelCase(String s) {
        if (isBlank(s)){
            return "";
        }
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL,s);
    }

    /**
     * @return toCamelCase(" hello_world ") == "helloWorld"
     */
    public String toCamelCase(String s) {
        if (isBlank(s)){
            return "";
        }
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,s);
    }
    /**
     * @return toUnderScoreCase("helloWorld") = "hello_world"
     */
    public String toUnderScoreCase(String s){
        if (isBlank(s)){
            return "";
        }
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,s);
    }

    /**
     *
     * @param s
     * @param prefix
     * @return  s = "string", prefix = "str" 返回 "ing"
     */
    public String removePrefix(String s, String prefix) {
        if (isNotBlank(s) && isNotBlank(prefix)){
            return s.replaceFirst(prefix,"");
        }
        return s;
    }
}
