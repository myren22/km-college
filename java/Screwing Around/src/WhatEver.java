import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class WhatEver extends JFrame{
	public static void main(String[] args){
		JFrame f = new WhatEver();
		f.setVisible(true);
	}
	
	public WhatEver(){
		super("Body mass index");
		setLayout(new GridLayout(2, 3));
		JPanel first = new JPanel();
		first.setLayout(new FlowLayout());;
		add(first);
		first.add(new JLabel("Weight(lb)"));
		//------------
		final JTextField weight = new JTextField(10);
		first.add(weight);
		first.add(new JLabel("Height(ft)"));
		final JTextField height = new JTextField(10);
		first.add(height);
		JButton button = new JButton("Go");
		first.add(button);
		
		JPanel second = new JPanel();
		second.setLayout(new FlowLayout(FlowLayout.CENTER));
		add(second);
		
		second.add( new JLabel("index"));
		//------------- beginning to lose clarity in photo
		final JLabel index = new JLabel(" ");
			second.add(index);
			
//			button.addActionListener(new ActionListener());
//			
//				@Override
//				public void actionPerformed(Action ???){
//					try{
//						String wS = weight.getText();
//						String hS = height.getText();
//						double w = Double.parseDouble(w);
//						double h = Double.parseDouble(h);
//						double result = (w+4.88)/Math.pow(h, 2);
//						mdex setText(String.format("%2f", ra));
//					}
//					catch(Exception e){
//						JoptionPanel showMessageDialog( whatever, );
//					}
//					
//				}
				
			
		pack();
	}
}
