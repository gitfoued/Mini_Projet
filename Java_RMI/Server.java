package Java_RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            listeImpl taskListServer = new listeImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("TaskListService", taskListServer);
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

