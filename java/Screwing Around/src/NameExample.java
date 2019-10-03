import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class NameExample extends JFrame {
	private JLabel jlbText;

	public NameExample() {
		super( "Example" );
		
		// menu
		JMenuBar     jmbMain = new JMenuBar();
		setJMenuBar( jmbMain );

		JMenu        jmnProgram = new JMenu( "Program" );
		jmbMain.add( jmnProgram );

		JMenuItem jmiEdit = jmnProgram.add( "Edit Name..." );
		jmnProgram.addSeparator();
		JMenuItem jmiExit = jmnProgram.add( "Exit" );
		
		jmiEdit.addActionListener(
				new ActionListener() {
					public void actionPerformed(final ActionEvent event) {
						editName();
					}
				});
		jmiExit.addActionListener(
				new ActionListener() {
					public void actionPerformed(final ActionEvent event) {
						dispose();
					}
				});

		// labels & button
		JPanel jpnPanel = new JPanel();
		add(   jpnPanel );
		
		JLabel jlbLabel = new JLabel( "Name: " );
		jlbLabel.setName( "label" );
		jpnPanel.add( jlbLabel );
		
		jlbText = new JLabel( "<no name>" ) {
			@Override
			public Dimension getPreferredSize() {
				final Dimension dimension = super.getPreferredSize();
				dimension.width = 200;
				return dimension;
			}
		};
		jlbText.setName( "current" );
		jpnPanel.add( jlbText );
		
		JButton       jbtEdit = new JButton( "Edit Name" );
		jpnPanel.add( jbtEdit );
		jbtEdit.addActionListener(
				new ActionListener() {
					public void actionPerformed(final ActionEvent event) {
						editName();
					}
				});
		
		pack();
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}

	private void editName() {
		String name  = jlbText.getText();
		String aName = NameExampleDialog.editName( name );
		if (aName.length() > 0 && !name.equals( aName )) {
			jlbText.setText( aName );
		}
	}

	public static void main(final String[] args) {
		JFrame frame = new NameExample();
		frame.setLocationRelativeTo( null );
		frame.setVisible( true );
	}
}