package com.prabhatxmishra.razorpay.common.exception;

import lombok.Getter;

@Getter
public class DuplicateException extends RuntimeException{

    private final String errorCode;

    public DuplicateException(String errorCode, String message) {
        this.errorCode = errorCode;
        super(message);
    }
}
