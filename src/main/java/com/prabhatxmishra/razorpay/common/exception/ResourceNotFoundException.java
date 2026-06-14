package com.prabhatxmishra.razorpay.common.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
    private final String resourceName;
    private final Object identifier;
    public ResourceNotFoundException(String message, String resourceName, Object identifier) {
        this.resourceName=resourceName;
        this.identifier =identifier;
        super(message);
    }
}
