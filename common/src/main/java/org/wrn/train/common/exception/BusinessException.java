package org.wrn.train.common.exception;

/**
 * @author: Admin
 * @Desc:
 * @create: 2024-11-13 17:21
 **/
public class BusinessException extends RuntimeException {

    private BusinessExceptionEnum e;

    public BusinessException(BusinessExceptionEnum e) {
        this.e = e;
    }

    public BusinessExceptionEnum getE() {
        return e;
    }

    public void setE(BusinessExceptionEnum e) {
        this.e = e;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
