
public class Cat extends Pet{
	public Cat(String name){
		
	}
	
	public boolean equals(Object otherCat){
		if(otherCat instanceof Cat)
		{
			String otherName = ((Cat)otherCat).toString();
			
			if(otherName.equals(Cat))
			{
				return true;
			}
		}
		return false;
	}
}
