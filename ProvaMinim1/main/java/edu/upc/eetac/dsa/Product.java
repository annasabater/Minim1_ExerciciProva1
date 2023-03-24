package edu.upc.eetac.dsa;

public class Product {
    private String id;
    private String name;
    private double price;
    private double sales;

    public Product(String id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = sales;
    }
    public String getId() { return this.id;  }
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }
    public double getSales() { return this.sales; }

    public void setPrice(double price) {
        this.price = price;
    }
}