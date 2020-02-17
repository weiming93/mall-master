package com.emond.mall.auth.translator;

import com.emond.mall.common.ThrowableUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.UnsupportedGrantTypeException;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * @description: 异常翻译器
 * @author: Emond Chan
 */
@Component
public class AuthWebResponseExceptionTranslator implements WebResponseExceptionTranslator {
    @Override
    public ResponseEntity translate(Exception e) throws Exception {
        ResponseEntity.BodyBuilder status = ResponseEntity.status(HttpStatus.BAD_REQUEST);
        ThrowableUtils.stackTraceToString(e);
        if (e instanceof UnsupportedGrantTypeException) {
            return status.body("不支持该认证类型");
        }
        if (e instanceof InvalidGrantException) {
            if (e.getMessage().equalsIgnoreCase("Invalid refresh token")){
                return status.body("refresh token无效");
            }else if(e.getMessage().equalsIgnoreCase("locked")){
                return status.body("用户已被锁定，请联系管理员");
            }else{
                return status.body("用户名或密码错误");
            }
        }
        return status.body("认证失败");
    }
}
