package com.davids.pocs.inventory.exception.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDetailsResponse {
    private LocalDateTime timestamp;
    private String message;
    private String errorCode;
    private String description;
    private String details;
    private int status;
}
