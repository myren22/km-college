import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Checked extends JFrame{
	public static void main(String[] args){
		JFrame f = new Checked();
		f.setVisible(true);
	}
	
	public Checked(){
		super("Checkedbox Status");
		setSize(500,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JMenuBar mnBar = new JMenuBar();
		setJMenuBar(mnBar);
//		add(mnBar);
		JMenu mnCheckBox = new JMenu("Checkbox");
		mnBar.add(mnCheckBox);
		JMenuItem mnitmStatus = new JMenuItem("Status");	
		
		
		mnCheckBox.add(mnitmStatus);

		
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		
		final JCheckBox checkBox = new JCheckBox("CheckBox", null, true);
		
		
		mainPanel.add(checkBox);
		add(mainPanel);
		
		
		mnitmStatus.addActionListener(
				new ActionListener(){
					public void actionPerformed(final ActionEvent event){
						boolean checkedState = checkBox.isSelected();
						if( checkedState){
							JOptionPane.showMessageDialog(null, new JLabel("Checkbox is ON"),
									"Message", JOptionPane.INFORMATION_MESSAGE);
							
						}
						else{
							JOptionPane.showMessageDialog(null, new JLabel("Checkbox is OFF"),
									"Message", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
//		pack();
	}
}