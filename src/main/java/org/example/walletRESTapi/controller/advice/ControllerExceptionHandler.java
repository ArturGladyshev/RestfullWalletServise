package org.example.walletRESTapi.controller.advice;

import org.example.walletRESTapi.exception.IllegalInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(IllegalInputException.class)
    ResponseEntity<Map<String, Object>> handleException(IllegalInputException e) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", HttpStatus.BAD_REQUEST);
        responseBody.put("code", HttpStatus.BAD_REQUEST.value());
        responseBody.put("message", e.getMessage());
        return ResponseEntity.badRequest().body(responseBody);
    }

}
