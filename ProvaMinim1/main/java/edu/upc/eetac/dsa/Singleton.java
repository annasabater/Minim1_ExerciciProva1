package edu.upc.eetac.dsa;

public class Singleton {
    private static Singleton instance;
    private Singleton(){
    }
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void setInstance(Singleton instance) {
        Singleton.instance = instance;
    }
}
