package com.vamshi.foodiecliapp.model;

import java.util.Objects;

public class Dish {
      /*
    add the following properties
    --------------------------------------
    Datatype                  variable
    --------------------------------------
    String                      id
    String                      name
    String                      description
    double                      price
     */

    /*
    1. All the fields should be private
    2. Create only no-arg constructor
    3. Create Getters and Setter methods
    4. Override hashCode() and equals() methods
    5. Override toString() methods
     */
    private  String id;
    private  String name;
    private  String description;
    private  double price;

    public Dish() {
    }

    public String getDishId() {
        return id;
    }

    public void setDishId(String id) {
        this.id = id;
    }

    public String getDishName() {
        return name;
    }

    public void setDishName(String name) {
        this.name = name;
    }

    public String getDishDescription() {
        return description;
    }

    public void setDishDescription(String description) {
        this.description = description;
    }

    public double getDishPrice() {
        return price;
    }

    public void setDishPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Double.compare(dish.price, price) == 0 && Objects.equals(id, dish.id) && Objects.equals(name, dish.name) && Objects.equals(description, dish.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
