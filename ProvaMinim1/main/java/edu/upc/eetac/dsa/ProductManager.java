package edu.upc.eetac.dsa;
import edu.upc.eetac.dsa.models.Order;
import java.util.List;

public interface ProductManager {
    public List<Product> ProductsByPrice();

    public List<Product> productsBySales();

    public void addOrder(Order order);

    public Order processOrder();

    public List<Order> ordersByUser(String userId);


    public int numUsers();

    public int numProducts();

    public int numOrders();

    public void addProduct(String productId, String name, double price);

    public void addUser(String productId, String name, String surname);
    public int numSales(String A001);
}