package form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;

public class Fenetre {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre window = new Fenetre();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fenetre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JPanel panel = new JPanel() {
			protected void paintComponent(Graphics g) {
		         super.paintComponent(g);
		         
		         
		         //new Thread(new Demo(g)).start();
		         
		         
		         Group maingroup = new Group();
		 		 Group group1 = new Group();
		 		 //Rectangle rectangle1 = new Rectangle(100,100,200,200);
		 		 //Rectangle rectangle2 = new Rectangle(400,200,200,200);
		 		 maingroup.addMember(group1);
		 		 //group1.addMember(rectangle1);
		 		 //group1.addMember(rectangle2);
		 		 //maingroup.draw(g);
		 		 System.out.println(maingroup);
		         
		         
		    }
		};
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
	    
	}

}
