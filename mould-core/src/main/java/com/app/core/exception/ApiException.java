package com.app.core.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends Exception {
    private int errCode = HttpStatus.INTERNAL_SERVER_ERROR.value();

    private String errMsg = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();

    public ApiException() {
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(int errCode, String errMsg) {
        super("[" + errCode + "] " + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}