package com.vamshi.foodiecliapp.ui;

import com.vamshi.foodiecliapp.controller.CustomerController;
import com.vamshi.foodiecliapp.exceptions.CustomerAlreadyExistsException;
import com.vamshi.foodiecliapp.model.Customer;
import com.vamshi.foodiecliapp.repository.CustomerRepository;
import com.vamshi.foodiecliapp.service.CustomerService;
import com.vamshi.foodiecliapp.service.CustomerServiceImpl;
import com.vamshi.foodiecliapp.util.Factory;

import java.util.Scanner;

public class Menu {

    public Menu() {

    }

    public void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("--------------------------------------------------------------------");
            System.out.println("                       WELCOME TO FOODIE APP                        ");
            System.out.println("____________________________________________________________________");
            System.out.println();
            System.out.println("Please select the option !");
            System.out.println("--------------------------");
            System.out.println("1. Register (New Customer)");
            System.out.println("2. Login  (Existing Customer");
            System.out.println("3. View Restaurants");
            System.out.println("4. View Menu");
            System.out.println("5. Place Orders");
            System.out.println("6. View Orders");
            System.out.println("7. Exit");

            System.out.println("Please enter your choice (1-7)");

            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    displayRegisterMenu();
                    break;
                case 7:
                    System.out.println("Thank you for using Foodie App, See you again!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Input. Please enter the valid input from(1-7)");
            }
        }
    }
    private void displayRegisterMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please register entering the following details\n");
        System.out.println("Enter Id");
        String id = scanner.nextLine();
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter E-mail");
        String email = scanner.nextLine();
        System.out.println("Enter Password");
        String password = scanner.nextLine();

        Customer customer = new Customer();
        customer.setCustomerId(id);
        customer.setCustomerName(name);
        customer.setCustomerEmail(email);
        customer.setCustomerPassword(password);

//        CustomerRepository customerRepository = new CustomerRepository();
//        CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository);
//        CustomerController customerController = new CustomerController(customerService);
          CustomerController customerController = Factory.getCustomerController();

          try{
              Customer savedCustomer = customerController.save(customer);
              if(savedCustomer != null){
                  System.out.println("Customer Registration Successful");
                  System.out.println("Details: ");
                  System.out.println("Id : " + customer.getCustomerId());
                  System.out.println("Name  : " + customer.getCustomerName());
                  System.out.println("Email : " + customer.getCustomerEmail());
                  System.out.println("Password : " + customer.getCustomerPassword());
              }else{
                  System.out.println("Some internal error occurred, please try again");
                  displayMainMenu();
              }
          }catch (CustomerAlreadyExistsException e){
              System.out.println(e.getMessage());
              System.out.println("Please login using MainMenu");
              displayMainMenu();
          }




    }
}



