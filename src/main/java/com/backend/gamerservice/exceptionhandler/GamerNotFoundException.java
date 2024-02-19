package com.backend.gamerservice.exceptionhandler;

public class GamerNotFoundException extends RuntimeException {
    public GamerNotFoundException(String s) {
        super(s);
    }
}
