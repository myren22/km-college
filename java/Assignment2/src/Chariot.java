//Kyle 100%. Never ended up contacting partner in project.

public class Chariot extends Vehicle{
	public Chariot(Driver driver, Mover mover)
	{
		super(driver, mover);
	}
	
	@Override
	public boolean equals(Object otherChariot){
		if(otherChariot instanceof Chariot)
		{
			Mover otherMover = ((Chariot)otherChariot).getMover();
			if(otherMover.equals(getMover()))
			{
				return true;
			}
		}
		return false;
	}

}
