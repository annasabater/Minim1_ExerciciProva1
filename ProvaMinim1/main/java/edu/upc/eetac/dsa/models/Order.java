package edu.upc.eetac.dsa.models;
import edu.upc.eetac.dsa.Product;
import java.util.LinkedList;
import java.util.List;

public class Order {
    private String ownerID;
    private List<Product> products;

    public Order(String ownerID){
        this.ownerID = ownerID;
        this.products = new LinkedList<>();
    }
    public String getOwnerID() {
        return ownerID;
    }

    public void addListProducts(int num, String product) {
    }

    public Object getListProducts(int num) {
        return this.products.get(num); //no es fica el string
    }
}
