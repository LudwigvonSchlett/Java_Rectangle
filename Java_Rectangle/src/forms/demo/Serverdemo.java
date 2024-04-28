package forms.demo;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import forms.*;

public class Serverdemo {
	
	public Serverdemo() {}

	public Serverdemo(String path) {
		Backuppath = path;
	}

	public Serverdemo(String path, int port) {
		Backuppath = path;
		this.port = port;
	}

	private Scene savedscene = new Scene();

	private String Backuppath = null;

	private int port = 1099;

	public void initialise() {
		try {
            Rsceneint remotescene = new Rsceneobjdemo(Backuppath);
            LocateRegistry.createRegistry(port);
            Naming.rebind("Saveserver", remotescene);

			remotescene.save(savedscene);

            System.out.println("Serveur opérationnel");

        } catch (Exception e) {
			e.printStackTrace();
        }
	}

	public void loadbackup() {
		if(Files.exists(Paths.get(Backuppath))){
			savedscene = Scene.loadXML(Backuppath);
		} else {
			System.out.println("Le fichier spécifié n'existe pas");
			savedscene.saveXML(Backuppath);
		}
		System.out.println("Backup configurée");
	}


	public static void main(String args[]) {

		if (args.length == 0) {
			
			Serverdemo server = new Serverdemo();

			server.initialise();

		} else if (args.length == 1) {
			
			Serverdemo server = new Serverdemo(args[0]);

			server.loadbackup();
			
			server.initialise();

		/*} else if (args.length == 2) {
			
			Server server = new Server(args[0], Integer.parseInt(args[1]));

			server.loadbackup();
			
			server.initialise();*/

		} else {
			System.out.println("Utilisation: java Server ou java Server <backuppath>");
			System.exit(0);
		}
        
    }

}
