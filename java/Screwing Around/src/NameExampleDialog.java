import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public final class NameExampleDialog extends JDialog {
	private JTextField jtfName;

	private NameExampleDialog() {
    	setTitle( "Edit Name" );

        JPanel jpnPanel = new JPanel();
        add(   jpnPanel );

        JLabel        jlbLabel = new JLabel( "Name: " );
        jpnPanel.add( jlbLabel );
        jlbLabel.setName( "label" );
        
        jtfName = new JTextField( 10 );
        jtfName.setName( "name" );
        jpnPanel.add( jtfName );
        
        JButton jbtOk     = new JButton( "Ok" );
        JButton jbtCancel = new JButton( "Cancel" );
        
        jpnPanel.add( jbtOk );
        jpnPanel.add( jbtCancel );
        
        jbtOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				final String name = jtfName.getText();
				if (name.length() > 0) {
					dispose();
				}
				else {
					JOptionPane.showMessageDialog( NameExampleDialog.this, "The name cannot be empty.", "Name Input Error", JOptionPane.ERROR_MESSAGE );
				}
			}
		});
        jbtCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent event) {
				jtfName.setText( "" );
				dispose();
			}
		});

        pack();
        
        setModal( true );
        setLocationRelativeTo( null );
	}

	public static String editName(String aName) {
		NameExampleDialog dialog = new NameExampleDialog();
		// set data
		dialog.jtfName.setText( aName );
		dialog.jtfName.selectAll();
		// display dialog
    	dialog.setVisible( true );
    	// get data
    	String result = dialog.jtfName.getText();
    	return result;
	}
}