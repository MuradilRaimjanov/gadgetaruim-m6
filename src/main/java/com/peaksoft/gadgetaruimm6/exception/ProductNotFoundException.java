package com.peaksoft.gadgetaruimm6.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException() {
        System.out.println("FilterResponse is empty!!!");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }


}
