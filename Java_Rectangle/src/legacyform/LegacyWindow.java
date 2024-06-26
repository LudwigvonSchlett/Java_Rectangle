package legacyform;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;

public class LegacyWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LegacyWindow window = new LegacyWindow();
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
	public LegacyWindow() {
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
		
		Group maingroup = new Group();
		System.out.println(maingroup);
		
		JPanel panel = new JPanel() {
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        // Draw the components hierarchy
		        maingroup.draw(g);
		    }
		};
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		
		Group group1 = new Group();
		Group group2 = new Group();
		Group group3 = new Group();
		Group group4 = new Group();
		Group group5 = new Group();
		Rectangle rectangle1 = new Rectangle(100, 100, 200, 200);
		Rectangle rectangle2 = new Rectangle(300, 300, 200, 200);
		Rectangle rectangle3 = new Rectangle(200, 400, 100, 300);
		Rectangle rectangle4 = new Rectangle(400, 200, 200, 200);
		Rectangle rectangle5 = new Rectangle(200, 400, 100, 300);
		maingroup.add(group1);
		maingroup.add(group3);
		group1.add(rectangle1);
		group1.add(group2);
		group2.add(rectangle2);
		group2.add(group4);
		group2.add(rectangle4);
		group3.add(rectangle3);
		group4.add(group5);
		group5.add(rectangle5);

		// Move group1
		group1.move(100, -100);
		System.out.println(maingroup);

		// Request repaint to reflect the changes
		/*
		if (panel.getParent() != null) {
		    panel.getParent().repaint();
		}
		*/
		
		
	    
	}

}