package com.bmt.odakalan.error;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String msg) { super(msg); }
}
