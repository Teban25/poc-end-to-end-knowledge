package com.davids.pocs.inventory.exception;

import com.davids.pocs.inventory.exception.model.ErrorDetailsResponse;
import com.davids.pocs.inventory.exception.model.InventoryErrorCode;

public class APIInventoryException extends RuntimeException {

    private final InventoryErrorCode inventoryErrorCode;
    private String details;
    public APIInventoryException(InventoryErrorCode inventoryErrorCode, String details) {
        super(inventoryErrorCode.getDescription());
        this.inventoryErrorCode = inventoryErrorCode;
        this.details = details;
    }

    public InventoryErrorCode getInventoryErrorCode() {
        return inventoryErrorCode;
    }

    public String getDetails() {
        return details;
    }
}
