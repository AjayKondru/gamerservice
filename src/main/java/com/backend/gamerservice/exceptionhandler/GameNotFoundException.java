package com.backend.gamerservice.exceptionhandler;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(String s) {
        super(s);
    }
}
