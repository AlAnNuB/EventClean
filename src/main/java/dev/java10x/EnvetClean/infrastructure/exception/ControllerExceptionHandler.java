package dev.java10x.EnvetClean.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateEventException(DuplicateEventException ex) {
        Map<String, String> response = new HashMap<>();

        response.put("Error:", ex.getMessage());
        response.put("Message:", "Evento já cadastrado no banco de dados");

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundEventException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundEventException(DuplicateEventException ex) {
        Map<String, String> response = new HashMap<>();

        response.put("Error:", ex.getMessage());
        response.put("Message:", "Evento não encontrado no banco de dados");

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
