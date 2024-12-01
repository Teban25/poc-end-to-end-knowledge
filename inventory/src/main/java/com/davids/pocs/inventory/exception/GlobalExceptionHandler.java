package com.davids.pocs.inventory.exception;

import com.davids.pocs.inventory.exception.model.ErrorDetailsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(APIInventoryException.class)
    public ResponseEntity<ErrorDetailsResponse> handleInventoryException(APIInventoryException exception) {
        ErrorDetailsResponse errorDetailsResponse = ErrorDetailsResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(exception.getDetails())
                .errorCode(exception.getInventoryErrorCode().getCode())
                .description(exception.getInventoryErrorCode().getDescription())
                .status(exception.getInventoryErrorCode().getHttpStatusCode().value())
                .build();
        return new ResponseEntity<>(errorDetailsResponse, exception.getInventoryErrorCode().getHttpStatusCode());
    }
}
