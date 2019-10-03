import java.util.ArrayList;


public class Pet {
	private String name;
	private ArrayList<Pet> collection;
	
	public Pet(String name){
		this.name = name;
	}
//	public void setString(String nameGiven){
//		this.name = nameGiven;
//	}
	
	public String toString(){
		return name;
	}
	
	
}
