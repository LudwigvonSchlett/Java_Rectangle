package forms;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements Rsceneint {

	private static final long serialVersionUID = 2997965801342334091L;

	public Server() throws RemoteException {}

	public Server(String path) throws RemoteException {
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
		savedscene.saveXML(backuppath);
		
	}

    public static void main(String args[]) {

		String path = args[0];
		int port = Integer.parseInt(args[1]);

        try {
            Rsceneint server = new Server(path);
            LocateRegistry.createRegistry(port);
            Naming.rebind("server", server);

			if (Files.exists(Paths.get(path))) {
				System.out.println("Le fichier " + path + " existe");

				try {
					server.save(Scene.loadXML(path));
					System.out.println("La sauvegarde a été restaurée depuis le fichier " + path + " avec succès");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Le fichier " + path + " est vide/illisible");
					server.savebackup(new Scene());
				}

			} else {
				System.out.println("Le fichier " + path + " n'existe pas");
				server.savebackup(new Scene());
			}

            System.out.println("Serveur opérationnel");

        } catch (Exception e) {
			e.printStackTrace();
        }

    }
}