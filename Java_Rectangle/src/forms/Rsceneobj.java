package forms;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Rsceneobj extends UnicastRemoteObject implements Rsceneint {

	public Rsceneobj() throws RemoteException {}
	
	Scene savedscene = null;
	
	String backuppath = "backup.xml";
	
	@Override
	public Scene load() throws RemoteException {
		return savedscene;
	}

	@Override
	public void save(Scene s1) throws RemoteException {
		savedscene = s1;
	}

	@Override
	public void backup() throws RemoteException {
		savedscene.saveXML(backuppath);
	}

}
