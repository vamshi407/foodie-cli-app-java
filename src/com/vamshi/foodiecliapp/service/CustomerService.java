package com.vamshi.foodiecliapp.service;

import com.vamshi.foodiecliapp.exceptions.CustomerAlreadyExistsException;
import com.vamshi.foodiecliapp.model.Customer;

public interface CustomerService {

    public Customer save(Customer customer) throws CustomerAlreadyExistsException;
}
