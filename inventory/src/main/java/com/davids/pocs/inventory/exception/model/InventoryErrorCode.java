package com.davids.pocs.inventory.exception.model;

import org.springframework.http.HttpStatus;

public enum InventoryErrorCode {
    // CODES FOR Controller-API
    PRODUCT_NOT_FOUND("API-ERR001", "The product with the given SKU was not found", HttpStatus.NOT_FOUND);

    private String code;
    private String description;
    private HttpStatus httpStatusCode;

    InventoryErrorCode(String code, String description, HttpStatus httpStatusCode) {
        this.code = code;
        this.description = description;
        this.httpStatusCode = httpStatusCode;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public HttpStatus getHttpStatusCode() {
        return httpStatusCode;
    }
}
