package forms.demo;

import forms.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Clientdemo {

    private Clientdemo() {}

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        System.out.println("Client started");

        String ip = "127.0.0.1";

        Rsceneint remotescene = (Rsceneint) Naming.lookup("rmi://" + ip + ":1099/Saveserver");

        Scene clientscene = remotescene.load();
        System.out.println(clientscene);

        clientscene.getGcontent().get(0).move(-25, 25);

        remotescene.save(clientscene);

        clientscene = remotescene.load();
        System.out.println(clientscene);
    }
}