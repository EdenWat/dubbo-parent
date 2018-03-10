package com.app.core.code;

public enum HttpCode {
    LOGIN_FAIL(10001, "未登录");

    private final int code;
    private final String msg;

    HttpCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}