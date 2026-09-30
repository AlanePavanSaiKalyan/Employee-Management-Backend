package com.pavan.EmployeeCrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> throwValidationException(MethodArgumentNotValidException exception){
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult()
                .getFieldErrors()
                .forEach(err->errors.put(err.getField(),err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> throwEmployeeNotFoundException(EmployeeNotFoundException exception){
//        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
        Map<String,Object> error = new HashMap<>();
        error.put("status",404);
        error.put("message",exception.getMessage());
        return ResponseEntity.status(404).body(error);

    }
}
