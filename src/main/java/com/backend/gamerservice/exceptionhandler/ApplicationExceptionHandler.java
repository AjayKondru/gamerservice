package com.backend.gamerservice.exceptionhandler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<?> handleException(Exception e)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler(value = {GameNotFoundException.class})
    public ResponseEntity<?> handleGameNotFoundException(Exception e)
    {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    }

    @ExceptionHandler(value = {GamerNotFoundException.class})
    public ResponseEntity<?> handleGamerNotFoundException(Exception e)
    {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
    }


    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    public ResponseEntity<?> handleDataIntegrityViolationException(Exception e)
    {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Game already exists");
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity<?> handleHttpMessageNotReadableException(Exception e)
    {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("values accepted for Level: [NOOB, PRO, INVINCIBLE]");
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
    {
        Map<String,String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->{errorMap.put(error.getField(),error.getDefaultMessage());});
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }
}
