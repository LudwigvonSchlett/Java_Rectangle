package rmiPackage;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import forms.Scene;

public class RmiClient {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        System.out.println("Client started");
            RemoteInterface obj = (RemoteInterface) Naming.lookup("rmi://localhost:1099/RemoteObject");
            String text = obj.hello();
            System.out.println("Message from Server: "+text);
    }
}
