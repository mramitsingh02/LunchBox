package com.lunchbox.common.errorfreamwork.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProcessingException extends RuntimeException {
    public ProcessingException(String s) {
        super(s);
    }
}
