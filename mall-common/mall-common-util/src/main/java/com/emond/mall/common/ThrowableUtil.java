package com.emond.mall.common;

import lombok.experimental.UtilityClass;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @description:    异常工具类
 * @author: Emond Chan
 */
@UtilityClass
public class ThrowableUtil {
    public String stackTraceToString(Throwable cause) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out);
        cause.printStackTrace(pout);
        pout.flush();

        String var3;
        try {
            var3 = new String(out.toByteArray());
        } finally {
            try {
                out.close();
            } catch (IOException var10) {
            }

        }

        return var3;
    }
}
