package com.lunchbox.common.errorfreamwork.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AccountAuthenticationException extends RuntimeException {
    public AccountAuthenticationException(String message) {
        super(message);
    }
}
