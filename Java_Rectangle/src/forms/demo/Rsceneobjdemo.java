package forms.demo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import forms.Rsceneint;
import forms.Scene;

public class Rsceneobjdemo extends UnicastRemoteObject implements Rsceneint {

	public Rsceneobjdemo() throws RemoteException {}

	public Rsceneobjdemo(String path) throws RemoteException {
		backuppath = path;
		backup = true;
	}
	
	Scene savedscene = null;
	
	String backuppath = null;

	Boolean backup = false;
	
	@Override
	public Scene load() throws RemoteException {
		return savedscene;
	}

	@Override
	public void save(Scene s1) throws RemoteException {
		savedscene = s1;		
	}

	@Override
	public void savebackup(Scene s1) throws RemoteException {
		savedscene = s1;
		if ((backup)&&(backuppath != null)){
			savedscene.saveXML(backuppath);
		}
	}

}
