package forms;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Clientdemo {

    private Clientdemo() {}

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        System.out.println("Client started");
        
        Rsceneint remotescene = (Rsceneint) Naming.lookup("rmi://localhost:1099/Saveserver");
        
        Scene clientscene = remotescene.load();
        System.out.println(clientscene);
    }
}