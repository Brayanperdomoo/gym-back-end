package com.sena.gym.exception;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/** Maneja errores globales y devuelve mensajes claros al frontend. */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleNotFound(ResourceNotFoundException ex){
        Map<String,Object> e=new HashMap<>(); e.put("timestamp",LocalDateTime.now()); e.put("status",404); e.put("error","Not Found"); e.put("message",ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleValidation(MethodArgumentNotValidException ex){
        Map<String,Object> errors=new HashMap<>(); ex.getBindingResult().getFieldErrors().forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String,Object>> handleDataIntegrity(DataIntegrityViolationException ex){
        Map<String,Object> e=new HashMap<>(); e.put("timestamp",LocalDateTime.now()); e.put("status",409); e.put("error","Conflict"); e.put("message","No se puede realizar la operacion. Puede existir un dato duplicado o una relacion asociada.");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
    }
}
