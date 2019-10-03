//Kyle 100%. Never ended up contacting partner in project.

public abstract class AbstractMover implements Mover{
	//construct int field
	private int force;	
	
	public AbstractMover(int force){
		this.force = force;
	}
	
	@Override
	public boolean equals(Object otherMover)
	{
		if(otherMover instanceof Mover)
		{
			int otherForce = ((Mover)otherMover).getForce();
			if(otherForce == force)
			{
				return true;
			}
		}
		return false;
	}
	
	
	public int getForce()
	{
		return force;
	}
	
	
	public int compareTo(Mover otherMover)
	{
		 int result;
		 result = this.force - otherMover.getForce();
		 return result;
	}
	
}
