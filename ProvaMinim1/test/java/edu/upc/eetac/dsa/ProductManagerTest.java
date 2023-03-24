package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.Order;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ProductManagerTest {
    private ProductManager pm;

    @Before
    public void setUp() {
        //Inicialización de variables antes de cada Test
        pm = ProductManagerImpl.getInstance();
        pm.addProduct("111222", "cacaolat", 3);
        pm.addProduct("111333", "cafe", 1.5);
        pm.addProduct("222333", "entrepa", 5);

        pm.addUser("111111", "David", "Sabater");
        pm.addUser("222222", "Carles", "Sabater");
        pm.addUser("333333", "Elisabeth", "Nualart");

        prepareOrders();
    }
    @After
    public void tearDown() {
        //Tareas a realizar después de cada test
        this.pm = null;
    }

    private void prepareOrders() { //realizar un pedido
        Order o1 = new Order("1111111");
        o1.addListProducts(1, "A001");
        this.pm.addOrder(o1);
        Assert.assertEquals(0, this.pm.numOrders());

        Order o2 = new Order("2222222");
        o2.addListProducts(2, "A002");
        this.pm.addOrder(o2);
        Assert.assertEquals(1, this.pm.numOrders());

        Order o3 = new Order("333333");
        o3.addListProducts(3, "A003");
        this.pm.addOrder(o3);
        Assert.assertEquals(2, this.pm.numOrders());
    }

    @Test
    public void productsByPriceTest() {
        List<Product> theList = this.pm.ProductsByPrice(); //passem el this perq es el teardown
        Assert.assertEquals("cafe", theList.get(0).getName()); //asserts that two objects are equal
        Assert.assertEquals("cacaolat", theList.get(1).getName());
        Assert.assertEquals("entrepa", theList.get(2).getName());
    }

    @Test
    public void productsBySalesTest() {
        List<Product> theList = pm.productsBySales();
        Assert.assertEquals("cafe", theList.get(0).getName());
        Assert.assertEquals("cacaolat", theList.get(1).getName());
        Assert.assertEquals("entrepa", theList.get(2).getName());
    }

    @Test
    public void addOrderTest() { //servir un pedido
        Assert.assertEquals(3, this.pm.numUsers()); // tenim 3 usuaris david carles i elisabeth
        Assert.assertEquals(3, this.pm.numProducts());// tenim 3 productes cacaolat cafe i entrepa
        Assert.assertEquals(3, this.pm.numOrders());

        Order o4 = new Order("4444444");
        o4.addListProducts(4, "B001");
        this.pm.addOrder(o4);
        Assert.assertEquals(4, this.pm.numOrders());
    }
    @Test
    public void processOrderTest() {
        Assert.assertEquals(3, this.pm.numUsers());
        Assert.assertEquals(4, this.pm.numProducts()); //n hem afegit un amb la funcio addOrderTest
        Assert.assertEquals(3, this.pm.numOrders());

        Order order1 = this.pm.processOrder();
        Assert.assertEquals(2, this.pm.numOrders());
        Assert.assertEquals(3, this.pm.numSales("A001")); //el numSales l'agafem el de la interficie ProductManager

        Order order2 = this.pm.processOrder();
        Assert.assertEquals(1, this.pm.numOrders());
        Assert.assertEquals(4, this.pm.numSales("A001"));

        Order order3 = this.pm.processOrder();
        Assert.assertEquals(0, this.pm.numOrders());
        Assert.assertEquals(7, this.pm.numSales("A001"));
    }
}


