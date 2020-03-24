package com.emond.mall.common.validator;

import com.emond.mall.common.annotation.ValidMobile;
import com.emond.mall.common.utils.RegexpUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description:
 * @author: Chen Weiming
 */
public class MobileValidator implements ConstraintValidator<ValidMobile, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            }else {
                String regex = RegexpUtils.MOBILE_REG;
                return RegexpUtils.match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }

}
