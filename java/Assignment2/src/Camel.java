//Kyle 100%. Never ended up contacting partner in project.

public class Camel extends Vehicle implements Mover{
	
	public Camel(Driver driver){
		super(driver, null);
		super.setMover(this);
	}
	
	
	// if it receives a non-null mover that is not itself then it throws an IllegalArgumentException
	@Override
	public void setMover(Mover otherMover)
	{
		if((otherMover != null) && (otherMover != this) )
		{		
		
		throw new IllegalArgumentException();		
		}
		super.setMover(this);
	}
	
	@Override
	public void setDriver(Driver otherDriver)
	{
		if(!(otherDriver instanceof Person)) 
		{		
		throw new IllegalArgumentException();
		}
		super.setDriver(otherDriver);
	}
	
	@Override
	public int getForce()
	{
		return 945;
	}
	
	@Override
	public boolean equals(Object otherCamel){
		if(otherCamel instanceof Camel)
		{
			int otherForce = ((Camel)otherCamel).getForce();
			if(otherForce == this.getForce())
			{
				return true;
			}
		}
		return false;
	}
	
	public int compareTo(Mover otherMover)
	{
		 int result;
		 result = this.getForce() - otherMover.getForce();
		 return result;
	}
}
