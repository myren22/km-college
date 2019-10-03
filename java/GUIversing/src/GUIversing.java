import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GUIversing extends JFrame{
	private JButton reverseButton;
	private JLabel textLabel;
	private JTextField textField;
	
	
	public static void main(String[] args){
		JFrame frame = new GUIversing();
		frame.setVisible(true);
	}
	
	public GUIversing(){
		//set title
		super("GUIversing");
		

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
				
		JPanel entriesPanel 	= new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		//set buttons
		reverseButton = new JButton("Reverse");
		textLabel = new JLabel("Text");
		textField = new JTextField(20);
		
		entriesPanel.add(textLabel);
		entriesPanel.add(textField);
		entriesPanel.add(reverseButton);
		
		add(entriesPanel);
		
		reverseButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(final ActionEvent event){
						//take text field and open a window message with reverse
						displayReverseDialog();
					}
				}
				);
		pack();
		
		
		//
		
	}
	
	private void displayReverseDialog(){
		String normalText = textField.getText();
		String reversedText;
		reversedText = new StringBuilder(normalText).reverse().toString();
		
		JOptionPane.showMessageDialog(this, new JLabel(reversedText), "Message",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
