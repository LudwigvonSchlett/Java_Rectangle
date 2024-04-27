package forms;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerDemo {
	
	public ServerDemo() {}

	public static void main(String args[]) {

		Scene savedscene = new Scene();

		String Backuppath = "backupp.xml";

        savedscene = Scene.loadXML(Backuppath);

        try {
            Rsceneint remotescene = new Rsceneobj();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("Saveserver", remotescene);

			remotescene.save(savedscene);

            System.out.println(" Server is ready.");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
