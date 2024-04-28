package forms;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class App {

    public static void main(String[] args) throws Exception {

		if (args.length == 0){
			args = new String[2];
			args[0] = "backup.xml";
			args[1] = "1099";
		}

		Server.main(args);

		Thread.sleep(50);/*

		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Window window = new Window();
					window.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); */

    }
}
