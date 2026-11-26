package com.freshmart.exception;

/** A more specific validation failure: the requested quantity is more than the units available. */
public class InsufficientStockException extends ValidationException {
    public InsufficientStockException(String productName, int requested, int available) {
        super("Not enough stock for " + productName + ": requested " + requested + ", available " + available + ".");
    }
}
