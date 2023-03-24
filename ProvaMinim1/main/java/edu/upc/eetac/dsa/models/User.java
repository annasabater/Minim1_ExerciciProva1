package edu.upc.eetac.dsa.models;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String surname;
    private String id;
    public ArrayList<Order> myOrders;

    public User(String id, String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.myOrders = new ArrayList<Order>();
    }
    public void addOrder(Order newOrder){
        this.myOrders.add(newOrder);
    }
    public String getName() {
        return this.name;
    }
    public String getId(){
        return this.id;
    }

    public List<Order> myOrders() {
        return myOrders;
    }
}
