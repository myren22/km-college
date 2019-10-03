import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.Timer;


public class SI extends JFrame{
	private JMenuBar jmbMain;
	private JMenu jmnGame, jmnHelp;
	private JMenuItem jmiNewGame, jmiPause, jmiResume, jmiQuit, jmiAbout;
	private SIpanel gamePanel;
	private boolean paused, gameRunning, defeated, newGame;
	private JLabel score, titleScreen;
	private Timer timer;
	

	// main
	public static void main(String args[]) {
		JFrame frame = new SI();
		frame.setVisible(true);
//		frame.setSize(4,)
	}
	public SI() {
		// title
		super("Space Invaders");
		
		// Size
		setSize(500,450);
		
		// window listener
		addWindowListener(new WindowListener() {
			public void windowClosing(WindowEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null, "Dare to Quit?",
						"Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					dispose();
				}
			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		

		// menu
		jmbMain = new JMenuBar();
		setJMenuBar(jmbMain);
		


		jmnGame = new JMenu("Game");
		jmbMain.add(jmnGame);
		jmnHelp = new JMenu("Help");
		//make it so that Help ends up on the right side of the menubar
		jmbMain.add(Box.createHorizontalGlue()); 
		jmbMain.add(jmnHelp);
		

		
		
		jmiNewGame = jmnGame.add("<html><u>N</u>ew Game</html>ew Game");
		jmnGame.add(new JSeparator()); // SEPARATOR
		jmiPause = jmnGame.add("<html><u>P</u>ause</html>ew Game");
		jmiResume = jmnGame.add("<html><u>R</u>esume</html>ew Game");
		jmnGame.add(new JSeparator()); // SEPARATOR
		jmiQuit = jmnGame.add("<html><u>Q</u>uit</html>ew Game");
		
		jmiResume.setEnabled(false);
		jmiPause.setEnabled(false);
		// ----
				//done--		
				//done--	
				//done--	
				//grey out pause resume
				
		
				//keyboard shortcuts
		jmiAbout = jmnHelp.add("About...");
		jmiNewGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		jmiPause.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		jmiResume.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
		jmiQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));


		// New Game Dialog
		jmiNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent event) {
				int result = JOptionPane.showConfirmDialog(null, "Start a new game?",
						"Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					//START A NEW GAME
					//new game method in SIpanel
					gamePanel.startGame();
					jmiPause.setEnabled(true);
					timer.start();
				}
			}
		});
		// Quit Dialog
		jmiQuit.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent event) {
				int result = JOptionPane.showConfirmDialog(null, "Dare to Quit?",
						"Confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		
		//About Message
		jmiAbout.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent event) {
				// bring up about dialog
				displayAboutDialog();
			}
		});
		gamePanel = new SIpanel(timer);
		
		//timer
		timer = new Timer(10, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamePanel.updateGame();				
			}
		});
			
		
		//enables the keypresses to apply to the panel
		gamePanel.setFocusable(true);		
		
		add(gamePanel);
		//actual height:399, width:494.
		
		//set Initial game state
			//pause timer
			//title screen, score, enemies loaded.
			//controls unresponsive
		
		//gameNew boolean
			//if game new, have title screen, all sprites in place
			//arrow keys and spacebar do nothing(no sound)
			//pause and resume are disabled
		//defeated boolean
			//pause and resume disabled
		//pause boolean
			//disable pause button
			//enable resume
		//game running boolean
			//
			
		// Resume
		jmiResume.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent event) {
				timer.start();
				jmiResume.setEnabled(false);
				jmiPause.setEnabled(true);
						
			}
		});
		// Pause
		jmiPause.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent event) {
				timer.stop();
				jmiResume.setEnabled(true);
				jmiPause.setEnabled(false);
			}
		});
		
//		pack();
		//not packing because that would override setSize
	}

	private void displayAboutDialog() {
		JOptionPane.showMessageDialog(
				this,
				new JLabel(
						"<html><hr>SpaceInvaders<br>by Kyle Myren and Nick Kirschke<hr></html>"),
				"About...", JOptionPane.INFORMATION_MESSAGE);
	}
}
