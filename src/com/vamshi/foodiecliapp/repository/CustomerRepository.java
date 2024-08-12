package com.vamshi.foodiecliapp.repository;

import com.vamshi.foodiecliapp.model.Customer;
import com.vamshi.foodiecliapp.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    public List<Customer> customerList;

    public CustomerRepository(){
        CsvReader csvReader = new CsvReader();
        this.customerList = csvReader.readCustomerFromCsv();
    }

    public List<Customer> getAllCustomers(){
        //Select * from customers;
        return this.customerList;
    }

    public Customer save(Customer customer){
        this.customerList.add(customer);
        return customer;
    }

    public Optional<Customer> findCustomerById(String id){
        return this.customerList.stream().filter(customer -> customer.getCustomerId().equals(id)).findFirst();
    }

}
