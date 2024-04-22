package oldform;

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
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
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
	
	protected static int MAX_WINDOW_WIDTH=700;
	
	protected static int MAX_WINDOW_HEIGHT=500;

	private Scene scene1 = new Scene();

	private String mode = "rectangle";
	
	private List<Rectangle> rectanglelist;
	
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
		
		this.rectanglelist = new ArrayList<Rectangle>();
		
		this.setJMenuBar(createJMenuBar());
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton rectangleButton = new JButton(new ImageIcon("icons/rectangle.png"));
		toolBar.add(rectangleButton);

		rectangleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode= "rectangle";
			}
		});
		
		JButton unionButton = new JButton(new ImageIcon("icons/union.png"));
		toolBar.add(unionButton);
		
		unionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode= "union";
			}
		});

		JButton interButton = new JButton(new ImageIcon("icons/inter.png"));
		toolBar.add(interButton);

		interButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode= "inter";
			}
		});
		
		JButton diffButton = new JButton(new ImageIcon("icons/diff.png"));
		toolBar.add(diffButton);

		diffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode= "diff";
			}
		});
		
		Canvas canvas = new Canvas() {
			public void paint(Graphics g) {
				super.paint(g);
				g.setColor(Color.BLACK);
				
				Rectangle r1 = new Rectangle(100,100,100,100);
				scene1.add(r1);
				Rectangle r2 = new Rectangle(10,10,100,100);
				scene1.add(r2);
				for (Shape rect : scene1.getGcontent()) {
					g.fillRect(rect.x, rect.y, rect.dx, rect.dy);
				}
			}
		};
		
		canvas.addMouseListener((MouseListener) new MouseAdapter() {
			private Point P1 = null;
			private Point P2 = null;

    public void mouseClicked(MouseEvent e) {

		if (mode.equals("rectangle")) {
			if (P1 == null) {
				P1 = e.getPoint();
			} else {
				P2 = e.getPoint();
				int width = Math.abs(P2.x - P1.x);
				int height = Math.abs(P2.y - P1.y);
				
				if (P1.x > P2.x && P1.y > P2.y) {
					scene1.add(new Rectangle(P1.x-width, P1.y-height, width, height));
				}
				else if (P1.x > P2.x && P1.y < P2.y) {
					scene1.add(new Rectangle(P1.x-width, P2.y-height, width, height));
				}
				else if (P1.x < P2.x && P1.y > P2.y) {
					scene1.add(new Rectangle(P2.x-width, P1.y-height, width, height));
				}
				else if (P1.x < P2.x && P1.y < P2.y) {
					scene1.add(new Rectangle(P2.x-width, P2.y-height, width, height));
				}
				
				canvas.repaint();
				P1 = null;
				P2 = null;
			}
		}

		if (mode.equals("union")) {
			
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
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();
		            // Ouvrez le fichier ici
		            // Par exemple, si c'est un fichier texte, vous pouvez le lire et l'afficher dans un JTextArea
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
		menuUndo.setIcon(new ImageIcon("icons/undo.png"));
		menuBar.add(menuUndo);
		
		
		JButton menuRedo = new JButton();
		menuRedo.setIcon(new ImageIcon("icons/redo.png"));
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
		            Desktop.getDesktop().browse(new URI("https://github.com/LudwigvonSchlett/Java_Rectangle"));
		        } catch (IOException | URISyntaxException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
		
		return menuBar;
	}
	
}
