package com.vamshi.foodiecliapp.service;

import com.vamshi.foodiecliapp.exceptions.CustomerAlreadyExistsException;
import com.vamshi.foodiecliapp.model.Customer;
import com.vamshi.foodiecliapp.repository.CustomerRepository;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{
    private final  CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) throws CustomerAlreadyExistsException {
        //If Customer already exists (id,name,email) then throw CustomerExistsException
        //else save the customer in the repository
        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getCustomerId());
        if(customerById.isPresent())
            throw new CustomerAlreadyExistsException("Customer Already exists with id :" + customer.getCustomerId());

        return this.customerRepository.save(customer);

    }
}
