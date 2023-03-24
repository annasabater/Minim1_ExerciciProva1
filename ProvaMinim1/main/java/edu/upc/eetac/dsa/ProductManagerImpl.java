package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.Order;
import edu.upc.eetac.dsa.models.User;
import org.apache.log4j.Logger;

import java.util.*;

public class ProductManagerImpl implements ProductManager {
    private static final Logger logger = Logger.getLogger(ProductManagerImpl.class);
    private static ProductManagerImpl instance = null; //SINGLETON
    private Map<String, User> users;
    private List<Product> products;
    private Queue<Order> orderQueue;

    private ProductManagerImpl() {
        users = new HashMap<String, User>();
        products = new ArrayList<>();
        orderQueue = new LinkedList<>();
    }

    public static ProductManagerImpl getInstance() { //SINGLETON
        if (instance == null) {
            instance = new ProductManagerImpl();
        }
        return instance;
    }
    public static void setInstance(ProductManagerImpl instance) { //SINGLETON
        ProductManagerImpl.instance = instance;
    }

    @Override
    public List<Product> ProductsByPrice() {
        logger.info("productsByPrice() creidem al metode");
        ArrayList <Product> productsByPrice = new ArrayList<>(this.products);
        productsByPrice.sort(Comparator.comparing(Product::getPrice));
        logger.info("Torna els productes per preu");
        return productsByPrice;
    }

    @Override
    public List<Product> productsBySales() {
        logger.info("productsBySales() creidem al metode");
        ArrayList <Product> productsBySales = new ArrayList<>(products);
        productsBySales.sort(Comparator.comparing(Product::getSales));
        logger.info("Torna els productes per descompte");
        return productsBySales;
    }

    @Override
    public void addOrder(Order order) { //Servir un pedido per ordre
        //logger.info("Adding order" + order);
        this.orderQueue.add(order);
    }

    @Override
    public Order processOrder() {
        Order o = this.orderQueue.poll();
        // The poll() method of Queue Interface returns and removes the element at the front end of the container.
        // It deletes the element in the container. The method does not throws an exception when the
        // Queue is empty, it returns null instead.
        String userID = o.getOwnerID();//l'agafem del order
        return o;
    }


    @Override
    public List<Order> ordersByUser(String userId) {
        User user = this.users.get(userId);
        return user.myOrders();
        //return users.orders();
    }

    @Override
    public int numUsers() {
        return users.size();
    }

    @Override
    public int numProducts() {
        return products.size();
    }

    @Override
    public int numOrders() {
        return orderQueue.size();
    }

    @Override
    public void addProduct(String productId, String name, double price) {
        products.add(new Product(productId, name, price));
        products.sort(Comparator.comparing(Product::getPrice));
    }

    @Override
    public void addUser(String userId, String name, String surname) {
        this.users.put(userId, new User(userId, name, surname));
    }

    @Override
    public int numSales(String A001) {
        return 0;
    }
}