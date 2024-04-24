    package rmiPackage;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiServer {
    public static void main(String[] args) {
        try {
            RemoteInterface obj = new RemoteObject();
            Registry registry = LocateRegistry.createRegistry(1099);
            Naming.rebind("RemoteObject", obj);
            System.out.println(" Server is ready.");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
