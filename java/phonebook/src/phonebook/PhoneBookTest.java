package phonebook;

//Kyle Myren 60%, Jackie Gray 40%


import static org.junit.Assert.*;

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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.junit.Test;

import edu.cnu.cs.gooey.Gooey;
import edu.cnu.cs.gooey.GooeyDialog;
import edu.cnu.cs.gooey.GooeyFrame;

public class PhoneBookTest {


	
	@Test
	public void testJOptionPaneMessageDialog(){
		Gooey.capture(new GooeyFrame(){

			@Override
			public void invoke() {
				PhoneBook.main(new String[]{});	
				
			}
			
			@Override
			public void handle(JFrame frame) {
				assertTrue("JFrame should be displayed", frame.isShowing());
				assertEquals("incorrect title", "PhoneBook", frame.getTitle());
			}


		});
	}
	
	@Test
	public void testMenus(){
		Gooey.capture(new GooeyFrame(){
			
			@Override
			public void invoke() {
				PhoneBook.main(new String[]{});
				
			}
			@Override
			public void handle(JFrame frame) {
			 	JMenuBar menubar =	Gooey.getMenuBar(	frame	);	
			 	JMenu program =	Gooey.getSubMenu(	menubar,	"Program"	);	
			 	JMenu help =	Gooey.getSubMenu(	menubar,	"Help"	);
			 	JMenuItem about	 =	Gooey.getMenu(	help,	"About..."	);		
			 	JMenuItem exit =	Gooey.getMenu(	program,	"Exit"	);		
			 	List<JMenu> menus =	Gooey.getMenus(	menubar	);	
			 	assertEquals(	"Incorrect	result",	2,	menus.size()	);	
			 	assertTrue	(	"Incorrect	result",	menus.contains(	program	));		
			 	assertTrue	(	"Incorrect	result",	menus.contains(	help	));	
			 	List<JMenuItem> programItems =	Gooey.getMenus(	program	);	
			 	assertEquals(	"Incorrect	result",	1,	programItems.size()	);				 		
			 	assertTrue	(	"Incorrect	result",	programItems.contains(exit));	
			 	List<JMenuItem> helpItems =	Gooey.getMenus(	help	);	
			 	assertEquals(	"Incorrect	result",	1,	helpItems.size()	);
			 	assertTrue	(	"Incorrect	result",	helpItems.contains(about));
				
			}

			
		});
	}
	
	@Test
	public void testAboutDialog(){
		Gooey.capture(new GooeyFrame(){
			
			@Override
			public void invoke() {
				PhoneBook.main(new String[]{});
				
			}
			@Override
			public void handle(JFrame frame) {
				JMenuBar menubar =Gooey.getMenuBar(frame);	
			 	JMenu help =	Gooey.getSubMenu(menubar,"Help");	
			 	final JMenuItem about =Gooey.getMenu(help,"About...");		
			 	Gooey.capture(new GooeyDialog(){	
					@Override	
					public void invoke(){	
						about.doClick();	
					}	
					@Override	
					public void handle(JDialog dialog){	
						assertEquals("Incorrect	title",	"Message", dialog.getTitle());	
						Gooey.getLabel(dialog, "<html><hr>PhoneBook<br>by Kyle Myren and Jackie Gray<hr></html>");	
						JButton	ok	= Gooey.getButton(dialog,"OK");
						ok.doClick();	
					}	
				
			 	});
			}

			
		});
	}
	
	@Test
	public void testExitDialog(){
		Gooey.capture(new GooeyFrame(){
			
			@Override
			public void invoke() {
				PhoneBook.main(new String[]{});
				
			}
			@Override
			public void handle(JFrame frame) {
				JMenuBar menubar =Gooey.getMenuBar(frame);	
			 	JMenu program =	Gooey.getSubMenu(menubar,"Program");	
			 	final JMenuItem exit =Gooey.getMenu(program,"Exit");	
			 	assertTrue("JFrame should be displayed", frame.isShowing());
			 	
			 	Gooey.capture(new GooeyDialog(){	
					@Override	
					public void invoke(){	
						exit.doClick();	
					}	
					@Override	
					public void handle(JDialog dialog){	
						assertEquals("Incorrect	title",	"Select an Option", dialog.getTitle());	
						Gooey.getLabel(dialog, "Want to exit?");	
						JButton	yes	= Gooey.getButton(dialog,"Yes");
						JButton	no	= Gooey.getButton(dialog,"No");
						JButton	cancel	= Gooey.getButton(dialog,"Cancel");
						
						no.doClick();	
						
					}	
				});
			 	assertTrue("JFrame should be displayed", frame.isShowing());
			 	Gooey.capture(new GooeyDialog(){	
					@Override	
					public void invoke(){	
						exit.doClick();	
					}	
					@Override	
					public void handle(JDialog dialog){	
						assertEquals("Incorrect	title",	"Select an Option", dialog.getTitle());	
						Gooey.getLabel(dialog, "Want to exit?");	
						JButton	yes	= Gooey.getButton(dialog,"Yes");
						JButton	no	= Gooey.getButton(dialog,"No");
						JButton	cancel	= Gooey.getButton(dialog,"Cancel");
						
						cancel.doClick();	
						
					}	
				});
			 	assertTrue("JFrame should be displayed", frame.isShowing());
			 	Gooey.capture(new GooeyDialog(){	
					@Override	
					public void invoke(){	
						exit.doClick();	
					}	
					@Override	
					public void handle(JDialog dialog){	
						assertEquals("Incorrect	title",	"Select an Option", dialog.getTitle());	
						Gooey.getLabel(dialog, "Want to exit?");	
						JButton	yes	= Gooey.getButton(dialog,"Yes");
						JButton	no	= Gooey.getButton(dialog,"No");
						JButton	cancel	= Gooey.getButton(dialog,"Cancel");
						
						yes.doClick();	
						
					}	
				});			 	
				assertFalse("JFrame should be hidden", frame.isShowing());			 	
			}

			
		});
	}
	
	@Test
	public void testAdd(){
		Gooey.capture(new GooeyFrame(){
			
			@Override
			public void invoke() {
				PhoneBook.main(new String[]{});
				
			}
			@Override
			public void handle(JFrame frame) {				
				JLabel entriesLabel = Gooey.getLabel(frame, "Entries:");
				JLabel indexLabel = Gooey.getLabel(frame, "0/0");
				JLabel nameLabel =  Gooey.getLabel(frame, "Name");
				JLabel phoneLabel =  Gooey.getLabel(frame, "Phone");
				JButton deleteButton = Gooey.getButton(frame, "Delete");
				JButton addButton = Gooey.getButton(frame, "Add");
				JButton nextButton = Gooey.getButton(frame, "Next");
				JButton beforeButton = Gooey.getButton(frame, "Before");
				assertFalse("Should be disabled", deleteButton.isEnabled());
				assertFalse("Should be disabled", nextButton.isEnabled());
				assertFalse("Should be disabled", beforeButton.isEnabled());
				assertTrue("Should be disabled", addButton.isEnabled());
				
				addButton.doClick();
				assertEquals("indexLabel should have increase to 1/1", "1/1", indexLabel.getText());
				assertTrue("Should be enabled", deleteButton.isEnabled());
				assertFalse("Should be disabled", beforeButton.isEnabled());
				assertFalse("Should be disabled", nextButton.isEnabled());
				
				
				
			}
		});	
	}
	
	@Test
	public void testSetEntries(){
		
		Gooey.capture(new GooeyFrame(){
		@Override
		public void invoke() {
			PhoneBook.main(new String[]{});
			
		}
		
		@Override
		public void handle(JFrame frame) {	
		 		List<Entry> entriesListTest = new ArrayList<Entry>();
				List<Entry> entriesListTest2 = new ArrayList<Entry>();
				List<Entry> empty = new ArrayList<Entry>();
				
				Entry anEntry = new Entry("kyle", "123-123-123", true, true);
				Entry anEntry2 = new Entry("kyle2", "123-123-123", true, true);
				Entry anEntry3 = new Entry("kyle3", "123-123-123", true, true);
		
				entriesListTest.add(anEntry);
				
				assertEquals("sdsafdagfadkl", empty, ((PhoneBook)frame).getEntries());
					
			}	
		});
			
				
				
			
	}
//	@Test
//	public void testCloseWindow(){
//		Gooey.capture(new GooeyFrame(){
//			
//			@Override
//			public void invoke() {
//				PhoneBook.main(new String[]{});
//				
//			}
//			
//			@Override
//			public void handle(final JFrame frame) {	
//			 	assertTrue("Incorrect result",frame.isVisible());	
//			 	//would pressing the close icon	close the window?	
//			 	
//			 	Gooey.capture(new GooeyDialog(){	
//					@Override	
//					public void invoke(){	
//						frame.getDefaultCloseOperation();	
//					}	
//					@Override	
//					public void handle(JDialog dialog){	
//						assertEquals("Incorrect	title",	"Select an Option", dialog.getTitle());	
//						JButton	yes	= Gooey.getButton(dialog,"Yes");
//						JButton	no	= Gooey.getButton(dialog,"No");
//						JButton	cancel	= Gooey.getButton(dialog,"Cancel");
//						
//						cancel.doClick();	
//						
//					}	
//				});
//			 	
//			 	assertTrue("JFrame should be displayed", frame.isShowing());
//			 	
//			 	Gooey.capture(new GooeyDialog(){	
//					@Override	
//					public void invoke(){	
//						frame.getDefaultCloseOperation();
//					}	
//					@Override	
//					public void handle(JDialog dialog){	
//						assertEquals("Incorrect	title",	"Select an Option", dialog.getTitle());	
//						Gooey.getLabel(dialog, "Want to exit?");	
//						JButton	yes	= Gooey.getButton(dialog,"Yes");
//						JButton	no	= Gooey.getButton(dialog,"No");
//						JButton	cancel	= Gooey.getButton(dialog,"Cancel");
//						
//						yes.doClick();	
//						
//					}	
//				});			 	
//				assertFalse("JFrame should be hidden", frame.isShowing());	
//	
//			 	frame.dispatchEvent(new	WindowEvent(frame,WindowEvent.WINDOW_CLOSING));	
//			 	assertTrue("Incorrect result",frame.isVisible());		
//				
//			}
//		});	
//	}
}

