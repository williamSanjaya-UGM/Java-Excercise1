package testRmi;

import java.rmi.Naming;

public class Server {
    public static void main(String[] args) throws Exception {
        MapClassExp mapClassExp=new MapClassExp();
        Naming.rebind("MAP",mapClassExp);
        System.out.println("Server is starting");

    }
}
