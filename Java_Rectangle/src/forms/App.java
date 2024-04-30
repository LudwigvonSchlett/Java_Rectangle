package forms;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class App {


	/*
	 * args[0] = path vers le fichier de backup
	 * args[1] = ip du serveur
	 * args[2] = port du serveur
	 */
    public static void main(String[] args) throws Exception {

		String[] serverargs = new String[2];
		String[] windowargs = new String[2];

		if (args.length == 3){
			
			windowargs[0] = args[1];
			windowargs[1] = args[2];
		
			serverargs[0] = args[0];
			serverargs[1] = args[2];

		} else {
			String defaultpath = "backup.xml";
			String defaultip = "127.0.0.1"; // "localhost"
			String defaultport = "1099";

			serverargs[0] = defaultpath;
			serverargs[1] = defaultport;

			windowargs[0] = defaultip;
			windowargs[1] = defaultport;

		}
		
		new Thread() {
			public void run() {
				try {
					Server.main(serverargs);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
		
				

		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Window window = new Window();
					window.configureserver(windowargs[0], Integer.parseInt(windowargs[1]));
					window.fetchserver();
					window.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

    }
}
