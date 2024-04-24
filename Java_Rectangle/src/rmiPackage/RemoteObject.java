package rmiPackage;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.management.remote.rmi.RMIServer;

import forms.Scene;

public class RemoteObject extends UnicastRemoteObject implements RemoteInterface {
    public RemoteObject() throws RemoteException {
        super();
    }

    public String hello() throws RemoteException {
        return "Hello World!";
    }
}
