package com.vamshi.foodiecliapp.model;

import java.util.Objects;

public class Customer {
     /*
    add the following properties
    --------------------------------------
    Datatype                  variable
    --------------------------------------
    String                      id
    String                      name
    String                      email
    String                      password
     */

    /*
    1. All the fields should be private
    2. Create only no-arg constructor
    3. Create Getters and Setter methods
    4. Override hashCode() and equals() methods
    5. Override toString() methods
     */

    private String id;
    private String name;
    private String email;
    private String password;

    //Constructor(No-Arg)
    public Customer() {
    }

    //Getters and Setters for fields


    public String getCustomerId() {
        return id;
    }

    public Customer setCustomerId(String id) {
        this.id = id;
        return this;
    }

    public String getCustomerName() {
        return name;
    }

    public Customer setCustomerName(String name) {
        this.name = name;
        return this;
    }

    public String getCustomerEmail() {
        return email;
    }

    public Customer setCustomerEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCustomerPassword() {
        return password;
    }

    public Customer setCustomerPassword(String password) {
        this.password = password;
        return this;
    }
//  Overriding equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return  Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(password, customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
