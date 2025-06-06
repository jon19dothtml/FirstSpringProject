package com.apuliadigital.corsospring.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class validationHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidation (MethodArgumentNotValidException ex){
        List<String> erorrs= ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .toList();
        return ResponseEntity.badRequest().body(erorrs);
    }
}
