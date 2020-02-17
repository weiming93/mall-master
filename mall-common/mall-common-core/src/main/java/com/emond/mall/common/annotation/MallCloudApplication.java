package com.emond.mall.common.annotation;

import com.emond.mall.common.selector.MallCloudApplicationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MallCloudApplicationSelector.class)
public @interface MallCloudApplication {
}
