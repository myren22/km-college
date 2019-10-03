import static org.junit.Assert.*;

import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.junit.Test;

import edu.cnu.cs.gooey.Gooey;
import edu.cnu.cs.gooey.GooeyDialog;
import edu.cnu.cs.gooey.GooeyFrame;


public class GUIversingTest {

	@Test
	public void testOpenVisible() {
		Gooey.capture(new GooeyFrame(){
			@Override
			public void invoke(){
				GUIversing.main(new String[]{});
			}
			@Override
			public void handle(JFrame frame){
				assertTrue("Jframe should be displayed", frame.isShowing());
				assertEquals("incorrect title", "GUIversing", frame.getTitle());
				
				final JButton reverseButton = Gooey.getButton(frame, "Reverse");
				JLabel textLabel = Gooey.getLabel(frame, "Text");
				
//				JTextField testTextField = Gooey.getTextField(frame);
//				testTextField.setText("1234");
				
				
//				Gooey.capture(new GooeyTextField(){
//					@Override
//					public void invoke(){
//						.setText("1234")
//					}
//					
//					@Override
//					public void handle(JTextField textField){
//						assertEquals("Incorrect Title",	"Message", dialog.getTitle());	
//						Gooey.getLabel(dialog, "4321");	
//						JButton	ok	= Gooey.getButton(dialog,"OK");
//						ok.doClick();	
//					
//							Gooey.capture(new GooeyDialog(){
//								@Override
//								public void invoke(){
//									reverseButton.doClick();
//								}
//								@Override
//								public void handle(JDialog dialog){
//									assertEquals("Incorrect Title",	"Message", dialog.getTitle());	
//									Gooey.getLabel(dialog, "4321");	
//									JButton	ok	= Gooey.getButton(dialog,"OK");
//									ok.doClick();	
//								}
//							});
//					}
//				});	
					
				
			}
		});
	}
	
	@Test
	public void testClosesProperly() {
		Gooey.capture(new GooeyFrame(){
			@Override
			public void invoke(){
				GUIversing.main(new String[]{});
			}
			@Override
			public void handle(JFrame frame){
				assertTrue("Jframe should be displayed", frame.isShowing());
				assertEquals("incorrect title", "GUIversing", frame.getTitle());
				
				int	actual = frame.getDefaultCloseOperation();	
			 	assertTrue("Incorrect result", actual == JFrame.DISPOSE_ON_CLOSE	);	
				
			 	frame.dispatchEvent(new	WindowEvent( frame, WindowEvent.WINDOW_CLOSING ));
			 	assertFalse("Jframe should be displayed", frame.isShowing());
//				Gooey.capture(new GooeyDialog(){	
//					@Override	
//					public void invoke(){	
//							close();
//					}
//					@Override	
//					public void handle(JDialog dialog){	
//						
//					}
//				});
			}
		});
	}
	
}
