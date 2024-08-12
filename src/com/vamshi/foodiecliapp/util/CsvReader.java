package com.vamshi.foodiecliapp.util;

import com.vamshi.foodiecliapp.model.Customer;
import com.vamshi.foodiecliapp.model.Dish;
import com.vamshi.foodiecliapp.model.Restaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;

public class CsvReader {
    /*
    Read the data from CSV files and create a list of objects
     */

    public  List<Customer> readCustomerFromCsv(){
        String customerCsvFilePath = "D:\\IntelliJ Projects\\foodie-cli-app-java\\data\\customers.csv";
        List<Customer> customerList = new ArrayList<>();
        //Java io classes (FileReader, BufferedReader)
        //try with resource
        String line;
       try(BufferedReader br = new BufferedReader(new FileReader(customerCsvFilePath))){
           String csvSplitBy = ",";
           br.readLine();
           while ((line = br.readLine())!= null){
           String[] data = line.split(csvSplitBy);
           Customer customer = new Customer();
           customer.setCustomerId(data[0]);
           customer.setCustomerName(data[1]);
           customer.setCustomerEmail(data[2]);
           customer.setCustomerPassword(data[3]);
           customerList.add(customer);
           }
       }catch (IOException e){
           System.out.println("File not found in the path" + customerCsvFilePath);
           System.exit(0);
           e.printStackTrace();
       }
        return customerList;
    }

    public List<Dish> readDishFromCsv(){
        String dishCsvFilePath = "D:\\IntelliJ Projects\\foodie-cli-app-java\\data\\dishes.csv";
        List<Dish> dishList = new ArrayList<>();
        String line;

        try(BufferedReader br = new BufferedReader(new FileReader(dishCsvFilePath))){
            String splitBy = ",";
            br.readLine();
            while((line = br.readLine()) != null){
            String[] data = line.split(splitBy);
            Dish dish = new Dish();
            dish.setDishId(data[0]);
            dish.setDishName(data[1]);
            dish.setDishDescription(data[2]);
            dish.setDishPrice(Double.parseDouble(data[3]));
            dishList.add(dish);

            }

        }catch (IOException e){
            System.out.println("File not found in the path" + dishCsvFilePath);
            e.printStackTrace();
        }
        return  dishList;
    }

    public List<Restaurant> readRestaurantFromCsv(){
        String restaurantCsvFilePath = "D:\\IntelliJ Projects\\foodie-cli-app-java\\data\\restaurants.csv";
        String line;
        List<Restaurant> restaurantList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(restaurantCsvFilePath))){
            String splitBy = ",";
            br.readLine();
            while((line = br.readLine()) != null){
                String[] data = line.split(splitBy);
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantId(data[0]);
                restaurant.setRestaurantName(data[1]);
                restaurant.setRestaurantAddress(data[2]);
                restaurant.setRestaurantMenu(Arrays.asList(data[3].split(":")));
                restaurantList.add(restaurant);

            }

        }catch (IOException e){
            System.out.println("File not found in the path" + restaurantCsvFilePath);
            e.printStackTrace();
            System.exit(0);
        }
        return restaurantList;
    }
}
