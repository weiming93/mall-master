package com.emond.mall.common.exception;

/**
 * 操作数据库数据异常
 * @author: Chen Weiming
 */
public class OperationException extends RuntimeException {
    public OperationException() {
        super("操作失败，请重试");
    }
}
