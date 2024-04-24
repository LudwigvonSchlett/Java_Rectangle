package rmiPackage;
import java.rmi.*;

public interface RemoteInterface extends Remote{
    public String hello() throws RemoteException;
}
