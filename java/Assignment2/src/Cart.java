//Kyle 100%. Never ended up contacting partner in project.

public class Cart extends Vehicle{
//	private Mover mover;
//	private Driver driver;
	
	public Cart(Driver person, Mover donkey)
	{
		super(person, donkey);
	}
	
	@Override
	public boolean equals(Object otherCart){
		if(otherCart instanceof Cart)
		{
			Mover otherMover = ((Cart)otherCart).getMover();
			if(otherMover.equals(getMover()))
			{
				return true;
			}
		}
		return false;
	}
	
}
