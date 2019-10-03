package phonebook;

//Kyle Myren 60%, Jackie Gray 40%

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PhoneBook extends JFrame{
	private List<Entry> entriesList = new ArrayList<Entry>();
	private int currentEntry = -1;
	
	//declare JObects, so that other personal methods can make use of.
	private 	JMenuBar		jmbMain;
	private 	JMenu			jmnProgram, jmnHelp;
	private 	JMenuItem		jmiExit, jmiAbout;
	private 	JPanel			entriesPanel, namePanel, phonePanel, checkBoxPanel, buttonPanel;
	private 	JLabel			indexLabel, entriesLabel;
	private 	JCheckBox		homeCheck, workCheck;
	private 	JButton			beforeButton, nextButton, addButton, deleteButton;
	private final	JTextField	nameField, phoneField;
	
	
	//main
	public static void main(String args[]){
		JFrame frame = new PhoneBook();
		frame.setVisible(true);
	}
	
	//default constructor
	public PhoneBook(){
		//title
		super("PhoneBook");
		
		//window listener
		addWindowListener(	
			new	WindowListener()	{		
				public	void	windowClosing(WindowEvent	arg0)	{	
					int result = JOptionPane.showConfirmDialog(PhoneBook.this,"Want to exit?");		
					if(result == JOptionPane.YES_OPTION){
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
		
		
		//menu
		jmbMain = new JMenuBar();
		setJMenuBar(jmbMain);
		
		jmnProgram = new JMenu("Program");
		jmbMain.add(jmnProgram);		
		jmnHelp = new JMenu("Help");
		jmbMain.add(jmnHelp);
		
		jmiExit = jmnProgram.add("Exit");
		jmiAbout = jmnHelp.add("About...");
		
		jmiExit.addActionListener(
				new ActionListener(){
					public void actionPerformed(final ActionEvent event){
						int result = JOptionPane.showConfirmDialog(PhoneBook.this,"Want to exit?");		
						if(result == JOptionPane.YES_OPTION){
							dispose();
						}					
						
						
					}
				});
		jmiAbout.addActionListener(
				new ActionListener(){
					public void actionPerformed(final ActionEvent event){
						//bring up about dialog
						displayAboutDialog();
					}
				});
		
				
		
		//5 rows 1 column
		setLayout(new GridLayout(5, 1));
		
		entriesPanel 	= new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		namePanel 		= new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		phonePanel 		= new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		checkBoxPanel 	= new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		buttonPanel 	= new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		//specify contents of panels
		//entriesPanel
		entriesLabel = new JLabel();
		entriesLabel.setText("Entries:");
		entriesPanel.add(entriesLabel);
		indexLabel = new JLabel();
		indexLabel.setText("0/0");
		entriesPanel.add(indexLabel);
		add(entriesPanel);
		//namePanel
		nameField = new JTextField(40);
		namePanel.add(new JLabel("Name"));
		namePanel.add(nameField);
		add(namePanel);
		//phonePanel
		phoneField = new JTextField(20);
		phonePanel.add(new JLabel("Phone"));
		phonePanel.add(phoneField);
		add(phonePanel);
		//checkBoxPanel
		homeCheck = new JCheckBox("Home");
		workCheck = new JCheckBox("Work");
		checkBoxPanel.add(homeCheck);
		checkBoxPanel.add(workCheck);
		add(checkBoxPanel);
		//buttonPanel
		beforeButton = new JButton("Before");
		nextButton = new JButton("Next");
		addButton = new JButton("Add");
		deleteButton = new JButton("Delete");
		buttonPanel.add(beforeButton);
		buttonPanel.add(nextButton);
		buttonPanel.add(addButton);
		buttonPanel.add(deleteButton);
		add(buttonPanel);
		
		beforeButton.setEnabled(false);
		nextButton.setEnabled(false);	
		deleteButton.setEnabled(false);
		
			//listeners
		beforeButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(final ActionEvent event){
						//before method
						currentEntry--;				
						
						updateEntries();						
					}
				});
		nextButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(final ActionEvent event){
						//next method
						currentEntry++;
						
						updateEntries();
					}
				});
		addButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(final ActionEvent event){
						//add method
						//take in name, phone, home, work.
							//forced to make the fields called finals.
						String aName =nameField.getText();
						String aPhone = phoneField.getText();
						boolean isHome=homeCheck.isSelected();
						boolean isWork=workCheck.isSelected();						
								
						Entry addedEntry= new Entry(aName, aPhone, isHome, isWork);
						entriesList.add(addedEntry);		
						currentEntry++;
						updateEntries();
						
					}
				});
		deleteButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(final ActionEvent event){
						//delete method
						if(entriesList.isEmpty()){
							updateEntries();
						}
						entriesList.remove(currentEntry);
						if(currentEntry>0){
							currentEntry--;
						}						
						updateEntries();
						
						//Discards the current entry and displays the entry that followed the one deleted.
					}
				});

			

		
		//
		
		//fits window to component sizes
		pack();
	}
	
	public List<Entry> getEntries(){
		return entriesList;
	}
//	
	public void setEntries(List<Entry>	aList){
		//clear current entries
		entriesList.clear();
		//add in new entries
		entriesList = aList;
		//set phonebook to first
		if(aList.isEmpty()){
			currentEntry = 0;
		}
		else{
			currentEntry = 1;
		}
	}
	
	private void updateEntries(){
		if(entriesList.isEmpty()){
			currentEntry = -1;
			
			indexLabel.setText("0/0");
			
			beforeButton.setEnabled(false);
			nextButton.setEnabled(false);
			deleteButton.setEnabled(false);
			
			nameField.setText(null);
			phoneField.setText(null);
			homeCheck.setSelected(false);
			workCheck.setSelected(false);
		}
		else{		
			Entry updatedEntry = entriesList.get(currentEntry);
			nameField.setText(updatedEntry.getName());
			phoneField.setText(updatedEntry.getPhone());
			homeCheck.setSelected(updatedEntry.isHome());
			workCheck.setSelected(updatedEntry.isWork());
			indexLabel.setText(currentEntry+1 +"/" + entriesList.size());
			deleteButton.setEnabled(true);
			//check if before should be toggleable
			if(currentEntry == 0 ){
				//disable
				beforeButton.setEnabled(false);
			}
			else{
				//enable
				beforeButton.setEnabled(true);
			}
			//check next
			if(currentEntry<entriesList.size()-1){
				//enable
				nextButton.setEnabled(true);
			}
			else{
				//disable
				nextButton.setEnabled(false);
			}
		}
	}
	
	private void displayAboutDialog(){
		JOptionPane.showMessageDialog(this, new JLabel("<html><hr>PhoneBook<br>by Kyle Myren and Jackie Gray<hr></html>"), "Message",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
	
	
	
	
	
}
