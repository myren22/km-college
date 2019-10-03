import java.util.NoSuchElementException;


public class Quiz5 {
	public static String foo(Quiz5Test.HotPotato potato){
		
		try{
			potato.blah();
		}			
		catch(ArrayIndexOutOfBoundsException e){
			return "index";
		}
		catch(NoSuchElementException e){
			return "element";
		}
		catch(RuntimeException e){
			return "runtime";
		}
		return "none";			
	}
}
