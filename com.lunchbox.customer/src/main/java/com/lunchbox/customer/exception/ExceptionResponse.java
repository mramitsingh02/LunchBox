package com.lunchbox.customer.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private String message;
    private LocalDateTime timestamp;
    private String details;
}