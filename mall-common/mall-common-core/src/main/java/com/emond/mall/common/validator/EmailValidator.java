package com.emond.mall.common.validator;


import com.emond.mall.common.RegexpUtils;
import com.emond.mall.common.annotation.ValidEmail;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail,String> {
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        try {
            if (StringUtils.isBlank(email)) {
                return true;
            }else {
                String regex = RegexpUtils.EMAIL_REG;
                return RegexpUtils.match(regex, email);
            }
        } catch (Exception e) {
            return false;
        }
    }

}
