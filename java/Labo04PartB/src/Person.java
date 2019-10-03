
public class Person {
	private String name;
	
	public Person(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public boolean equals(Object otherPerson){
		if(otherPerson instanceof Person)
		{
			String otherName = ((Person)otherPerson).getName();
			if(otherName.equals(name))
			{
				return true;
			}
		}
		return false;		
	}
	
	public int compareTo(Person otherPerson){
		return name.compareTo(otherPerson.getName());
	}
}
