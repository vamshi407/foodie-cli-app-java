package com.vamshi.foodiecliapp.exceptions;

import com.vamshi.foodiecliapp.model.Customer;

public class CustomerAlreadyExistsException extends Exception{
    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
