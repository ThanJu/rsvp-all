package com.highteam.router.common.m;

public final class BusinessException extends RuntimeException {
    public final static String defaultcode = "500";
    private static final long serialVersionUID = -6827343172666309288L;
    private String code;
    private String msg;

    public BusinessException(String msg) {
        this(defaultcode, msg, null);
    }

    public BusinessException(Throwable cause) {
        this(defaultcode, cause.getMessage(), cause);
    }

    public BusinessException(String code, String msg) {
        this(code, msg, null);
    }

    public BusinessException(String code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}