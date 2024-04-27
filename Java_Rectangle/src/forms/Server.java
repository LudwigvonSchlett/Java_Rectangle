package forms;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
	
	public Server() {}

	public static void main(String args[]) {

		Scene savedscene = new Scene();

		String Backuppath = "backup.xml";

		if(Files.exists(Paths.get(Backuppath))){
			savedscene = Scene.loadXML(Backuppath);
		} else {
			System.out.println("Le fichier spécifié n'existe pas");
			savedscene.saveXML(Backuppath);
		}     

        try {
            Rsceneint remotescene = new Rsceneobj();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("Saveserver", remotescene);

			remotescene.save(savedscene);

            System.out.println("Serveur opérationnel");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
