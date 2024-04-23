package forms;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Color;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	
	protected static int MAX_WINDOW_WIDTH=1920;
	
	protected static int MAX_WINDOW_HEIGHT=1080;

	private Scene scene1 = new Scene();
	private Scene scene = new Scene();
	
	private String mode = "Select";
	
	/*MAIN*/
	public static void main(String[] args) throws Exception {
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
		});
	}
	
	private void closeWindow() { //fenetre de vérification avant de quitter
	    int clicked = JOptionPane.showConfirmDialog(Window.this, "Avez-vous enregistrer ?", "Quitter", JOptionPane.YES_NO_OPTION);
	    if (clicked == JOptionPane.YES_OPTION) {
	        dispose();
	    }
	}

	public Window() { //constructeur
		
		super("Paint");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(714, 611);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.setJMenuBar(createJMenuBar());

		// Test de la classe Scene
		
		//scene1.add(new Inter(new Rect(10,10,100,100),new Rect(50,50,150,150)));
		//scene1.add(new Diffe(new Rect(400,100,600,300),new Rect(450,150,550,250)));
		System.out.println(scene1);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton RectButton = new JButton(new ImageIcon(this.getClass().getResource("icons/rectangle.png")));
		toolBar.add(RectButton);

		RectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode= "Rectangle";
			}
		});
		
		JButton unionButton = new JButton(new ImageIcon(this.getClass().getResource("icons/union.png")));
		toolBar.add(unionButton);
		
		unionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode= "Union";
			}
		});

		JButton interButton = new JButton(new ImageIcon(this.getClass().getResource("icons/inter.png")));
		toolBar.add(interButton);

		interButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode= "Inter";
			}
		});
		
		JButton diffButton = new JButton(new ImageIcon(this.getClass().getResource("icons/diff.png")));
		toolBar.add(diffButton);

		diffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode= "Diff";
			}
		});
		
		Canvas canvas = new Canvas() {
			public void paint(Graphics g) {
				super.paint(g);
				g.setColor(Color.decode("#D6D9DF"));
				g.fillRect(0, 0, MAX_WINDOW_WIDTH, MAX_WINDOW_HEIGHT);
				scene1.draw(g);
				
			}
		};
		
		canvas.addMouseListener((MouseListener) new MouseAdapter() {
			private Point P1 = null;
			private Point P2 = null;
			private Point P3 = null;
			Shape form1 = null;
			Shape form2 = null;

		    @SuppressWarnings("unused")
			public void mouseClicked(MouseEvent e) {

				if (mode.equals("Select")) {
					System.out.println("mode = Select");
					P3 = e.getPoint();
					Shape form = scene1.select(P3.x, P3.y);
					if (form != null) {
						//System.out.println(form);
					}
					canvas.repaint();
					P3 = null;
				}
		
				if (mode.equals("Rectangle")) {
					scene1.unselectall();
					if (P1 == null) {
						P1 = e.getPoint();
						canvas.repaint();
					} else {
						P2 = e.getPoint();
						
						if (P1.x >= P2.x && P1.y >= P2.y) {
							scene1.add(new Rect(P2.x, P2.y, P1.x, P1.y));
						}
						else if (P1.x >= P2.x && P1.y <= P2.y) {
							scene1.add(new Rect(P2.x, P1.y, P1.x, P2.y));
						}
						else if (P1.x <= P2.x && P1.y >= P2.y) {
							scene1.add(new Rect(P1.x, P2.y, P2.x, P1.y));
						}
						else if (P1.x <= P2.x && P1.y <= P2.y) {
							scene1.add(new Rect(P1.x, P1.y, P2.x, P2.y));
						}

						canvas.repaint();
						P1 = null;
						P2 = null;

						mode = "Select";
					}
				}
		
				if (mode.equals("Union")) {
					
				}

				if (mode.equals("Inter")) {
					scene1.unselectall();
					if (P1 == null) {
						P1 = e.getPoint();
						form1 = scene1.select(P1.x, P1.y);
						canvas.repaint();
					}
					else{
						P2 = e.getPoint();
						form2 = scene1.select(P2.x, P2.y);
						Inter intersection = null;
						intersection = new Inter(form1, form2);
						scene1.add(intersection);
						System.out.println(intersection);
						if (intersection != null) {
							scene1.remove(form1);
							scene1.remove(form2);
						}
						else {
							System.out.println("Intersection impossible");
						}
						canvas.repaint();
						P1 = null;
						P2 = null;
						form1 = null;
						form2 = null;
						intersection = null;
						mode = "Select";
					}
				}

				if (mode.equals("Diff")) {
					scene1.unselectall();
					if (P1 == null) {
						P1 = e.getPoint();
						form1 = scene1.select(P1.x, P1.y);
						canvas.repaint();
					}
					else{
						P2 = e.getPoint();
						form2 = scene1.select(P2.x, P2.y);
						
						
						Diffe difference = null;
						difference = new Diffe(form1, form2);
						scene1.add(difference);
						System.out.println(difference);
						if (difference != null) {
							scene1.remove(form1);
							scene1.remove(form2);
						}
						else {
							System.out.println("Intersection impossible");
						}
						canvas.repaint();
						P1 = null;
						P2 = null;
						form1 = null;
						form2 = null;
						mode = "Select";
					}
				}
		    }
		});
		
		getContentPane().add(canvas, BorderLayout.CENTER);
		
		
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(java.awt.event.WindowEvent e) {
				closeWindow();
				}
		});
	}
		

	private JMenuBar createJMenuBar() { //barre de menu
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		menuFile.setMnemonic('F');
		
		
		JMenuItem menuNew = new JMenuItem("New");
		menuFile.add(menuNew);
		menuNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		menuNew.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new Window().setVisible(true);
		    }
		});
		
		JMenuItem menuOpen = new JMenuItem("Open File...");
		menuFile.add(menuOpen);
		menuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		menuOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Specify a file to open");   
		
				int userSelection = fileChooser.showOpenDialog(null);
		
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File fileToOpen = fileChooser.getSelectedFile();
					// Create a new window
					Window newWindow = new Window();
					// Load the XML file in the new window
					scene.loadXML(fileToOpen.getAbsolutePath());
					System.out.println(newWindow.scene.toString());
					newWindow.setVisible(true);
				}
			}
		});
		
		menuFile.addSeparator();
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuFile.add(menuSave);
		menuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		
		JMenuItem menuSaveAs = new JMenuItem("Save As...");
		menuFile.add(menuSaveAs);
		menuSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));
		menuSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Specify a file to save");   
		
				int userSelection = fileChooser.showSaveDialog(null);
		
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File fileToSave = fileChooser.getSelectedFile();
					scene1.saveXML(fileToSave.getAbsolutePath());
				}
			}
		});
		
		menuFile.addSeparator();
		
		JMenuItem menuImport = new JMenuItem("Import from Server");
		menuFile.add(menuImport);
		menuImport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
		
		JMenuItem menuExport = new JMenuItem("Export to Server");
		menuFile.add(menuExport);
		menuExport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
		
		menuFile.addSeparator();
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuFile.add(menuExit);
		menuExit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        closeWindow();
		    }
		});
		
		JButton menuUndo = new JButton();
		menuUndo.setIcon(new ImageIcon(this.getClass().getResource("icons/undo.png")));
		menuBar.add(menuUndo);
		
		
		JButton menuRedo = new JButton();
		menuRedo.setIcon(new ImageIcon(this.getClass().getResource("icons/redo.png")));
		menuBar.add(menuRedo);
		
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		menuHelp.setMnemonic('H');
		
		JMenuItem menuGithub = new JMenuItem("GoTo Github Project");
		menuHelp.add(menuGithub);
		menuGithub.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));
		menuGithub.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Desktop.getDesktop().browse(new URI("https://github.com/LudwigvonSchlett/Java_Rect"));
		        } catch (IOException | URISyntaxException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
		
		return menuBar;
	}

	
	
}
