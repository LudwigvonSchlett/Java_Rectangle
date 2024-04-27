package forms;

import java.rmi.*;

public interface Rsceneint extends Remote{

    public Scene load() throws RemoteException;

    public void save(Scene s1) throws RemoteException;
    
    public void backup() throws RemoteException;

}
