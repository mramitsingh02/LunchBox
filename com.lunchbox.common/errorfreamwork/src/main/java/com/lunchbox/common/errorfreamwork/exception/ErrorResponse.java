package com.lunchbox.common.errorfreamwork.exception;

public class ErrorResponse {
    private final String msg;
    private final Exception ex;

    public ErrorResponse(String msg, Exception ex) {
        this.msg = msg;
        this.ex = ex;
    }
}
