
public class Dog extends Pet {
	public Dog(String nameVar){
		new Pet(nameVar);
	}
	
	public boolean equals(Object otherDog){
		if(otherDog instanceof Dog)
		{
			String otherName = ((Dog)otherCat).toString();
			
			if(otherName.equals(Dog))
			{
				return true;
			}
		}
		return false;
	}
}
