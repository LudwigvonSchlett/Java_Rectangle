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
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Stack;
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

	private Stack<Scene> leftStack = new Stack<Scene>();

	private Stack<Scene> rightStack = new Stack<Scene>();
	
	private String mode = "Select";

	private String filepath = null;

	private Shape ShapeSelected = null;

	private int oldX = -1, oldY = -1;

	private Point P1 = null;
			
	private Point P2 = null;

	
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

		// Canvas
		Canvas canvas = new Canvas() {
			public void paint(Graphics g) {
				super.paint(g);
				g.setColor(Color.decode("#D6D9DF"));
				g.fillRect(0, 0, MAX_WINDOW_WIDTH, MAX_WINDOW_HEIGHT);
				scene1.draw(g);
			}
		};
		
		// Test de la classe Scene
		
		scene1.add(new Inter(new Rect(0,0,100,100),new Rect(50,50,150,150)));
		scene1.add(new Diffe(new Rect(400,100,600,300),new Rect(450,150,550,250)));
		System.out.println(scene1);
		
		// Barre d'outils
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		getContentPane().add(toolBar, BorderLayout.NORTH);

		JButton selectButton = new JButton(new ImageIcon(this.getClass().getResource("icons/select.png")));
		toolBar.add(selectButton);

		JButton moveButton = new JButton(new ImageIcon(this.getClass().getResource("icons/move.png")));
		toolBar.add(moveButton);

		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scene1.unselectall();
				mode= "Select";
				P1 = null;
				P2 = null;
				scene1.unselectall();
				canvas.repaint();
			}
		});

		moveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scene1.unselectall();
				mode= "Move";
				P1 = null;
				P2 = null;
				scene1.unselectall();
				canvas.repaint();
			}
		});

		toolBar.addSeparator();
		
		JButton RectButton = new JButton(new ImageIcon(this.getClass().getResource("icons/rectangle.png")));
		toolBar.add(RectButton);

		RectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scene1.unselectall();
				mode= "Rectangle";
				P1 = null;
				P2 = null;
				scene1.unselectall();
				canvas.repaint();
			}
		});

		toolBar.addSeparator();
		
		JButton unionButton = new JButton(new ImageIcon(this.getClass().getResource("icons/union.png")));
		toolBar.add(unionButton);

		JButton interButton = new JButton(new ImageIcon(this.getClass().getResource("icons/inter.png")));
		toolBar.add(interButton);

		
		JButton diffButton = new JButton(new ImageIcon(this.getClass().getResource("icons/diff.png")));
		toolBar.add(diffButton);

		unionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scene1.unselectall();
				mode= "Union";
				P1 = null;
				P2 = null;
				scene1.unselectall();
				canvas.repaint();
			}
		});

		interButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scene1.unselectall();
				mode= "Inter";
				P1 = null;
				P2 = null;
				scene1.unselectall();
				canvas.repaint();
			}
		});
		
		diffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scene1.unselectall();
				mode= "Diff";
				P1 = null;
				P2 = null;
				scene1.unselectall();
				canvas.repaint();
			}
		});

		// Barre de menu
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
		            try {
						filepath = selectedFile.getPath();
		                scene1 = Scene.loadXML(filepath);          
						leftStack.clear();
						rightStack.clear();
		                canvas.repaint();
		            } catch (Exception e1) {
		                e1.printStackTrace();
		            }
					
		        }
		    }
		});
		
		menuFile.addSeparator();
		
		JMenuItem menuSave = new JMenuItem("Save XML");
		menuFile.add(menuSave);
		menuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		menuSave.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if(filepath == null) {
					JFileChooser fileChooser = new JFileChooser();
					int returnValue = fileChooser.showOpenDialog(null);
					if (returnValue == JFileChooser.APPROVE_OPTION) {
						File selectedFile = fileChooser.getSelectedFile();
						try {
							filepath = selectedFile.getPath();
							scene1.saveXML(filepath);          
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else {
					scene1.saveXML(filepath);
				}
		    }
		});
		
		JMenuItem menuSaveAs = new JMenuItem("Save XML As...");
		menuFile.add(menuSaveAs);
		menuSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));
		menuSaveAs.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JFileChooser fileChooser = new JFileChooser();
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();
		            try {
						filepath = selectedFile.getPath();
		                scene1.saveXML(filepath);          
		            } catch (Exception e1) {
		                e1.printStackTrace();
		            }
					
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
		
		menuUndo.setEnabled(false);
		menuRedo.setEnabled(false);

		menuUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((leftStack.empty() == false)&&(leftStack.peek().equals(scene1)==false)){
					rightStack.push(scene1.copy());
					scene1 = leftStack.pop();
					canvas.repaint();
				}
				menuUndo.setEnabled(!leftStack.empty());
        		menuRedo.setEnabled(!rightStack.empty());
			}
		});		

		menuRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((rightStack.empty() == false)&&(rightStack.peek().equals(scene1)==false)) {
					leftStack.push(scene1.copy());
					scene1 = rightStack.pop();
					canvas.repaint();
				}
				menuUndo.setEnabled(!leftStack.empty());
        		menuRedo.setEnabled(!rightStack.empty());
			}
		});	
		
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

		this.setJMenuBar(menuBar);
		
		// Actions souris
		canvas.addMouseListener((MouseListener) new MouseAdapter() {
			
			private Shape form1 = null;
			
			private Shape form2 = null;

		    public void mouseClicked(MouseEvent e) {

				if (mode.equals("Select")) {
					//System.out.println("mode = Select");
					P1 = e.getPoint();
					ShapeSelected = scene1.select(P1.x, P1.y);
					canvas.repaint();
					P1 = null;
					P2 = null;
				} else {
					scene1.unselectall();
				}

				if (mode.equals("Rectangle")) {
					//scene1.unselectall();
					if (P1 == null) {
						//scene1.unselectall();
						P1 = e.getPoint();
						canvas.repaint();
					} else {
						P2 = e.getPoint();
						
						leftStack.push(scene1.copy());
						menuUndo.setEnabled(true);
						rightStack.clear();

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
					//scene1.unselectall();
					if (P1 == null) {
						//scene1.unselectall();
						P1 = e.getPoint();
						form1 = scene1.select(P1.x, P1.y);
						canvas.repaint();
					}
					else{
						P2 = e.getPoint();
						form2 = scene1.select(P2.x, P2.y);

						Union union = null;
						union = new Union(form1.copy(), form2.copy());
						
						System.out.println(union);

						leftStack.push(scene1.copy());
						menuUndo.setEnabled(true);
						rightStack.clear();

						scene1.add(union);
						scene1.remove(form1);
						scene1.remove(form2);
						scene1.unselectall();
						
						canvas.repaint();
						P1 = null;
						P2 = null;
						form1 = null;
						form2 = null;
						union = null;
						mode = "Select";
					}
				}

				if (mode.equals("Inter")) {
					//scene1.unselectall();
					if (P1 == null) {
						//scene1.unselectall();
						P1 = e.getPoint();
						form1 = scene1.select(P1.x, P1.y);
						canvas.repaint();
					}
					else{
						P2 = e.getPoint();
						form2 = scene1.select(P2.x, P2.y);

						Inter intersection = null;
						intersection = new Inter(form1.copy(), form2.copy());
						
						System.out.println(intersection);

						leftStack.push(scene1.copy());
						menuUndo.setEnabled(true);
						rightStack.clear();

						scene1.add(intersection);
						scene1.remove(form1);
						scene1.remove(form2);
						
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
					//scene1.unselectall();
					if (P1 == null) {
						//scene1.unselectall();
						P1 = e.getPoint();
						form1 = scene1.select(P1.x, P1.y);
						canvas.repaint();
					}
					else{
						P2 = e.getPoint();
						form2 = scene1.select(P2.x, P2.y);
						
						Diffe difference = null;
						difference = new Diffe(form1.copy(), form2.copy());
						
						System.out.println(difference);

						leftStack.push(scene1.copy());
						menuUndo.setEnabled(true);
						rightStack.clear();
								
						scene1.add(difference);
						scene1.remove(form1);
						scene1.remove(form2);
					
						
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

		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (mode.equals("Move")) {
					Point point = e.getPoint();
					ShapeSelected = scene1.select(point.x, point.y);
					oldX = point.x;
					oldY = point.y;
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (mode.equals("Move")) {
					ShapeSelected = null;
					scene1.unselectall();
					canvas.repaint();
				}
			}
		});
		
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (mode.equals("Move") && ShapeSelected != null) {
					Point point = e.getPoint();
					int dx = point.x - oldX;
					int dy = point.y - oldY;
					ShapeSelected.move(dx, dy);
					oldX = point.x;
					oldY = point.y;
					canvas.repaint();
				}
			}
		});
	}
}