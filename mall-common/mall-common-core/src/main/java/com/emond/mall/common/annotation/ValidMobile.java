package com.emond.mall.common.annotation;

import com.emond.mall.common.validator.MobileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: Chen Weiming
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MobileValidator.class)
public @interface ValidMobile {

    String message() default "手机号不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}