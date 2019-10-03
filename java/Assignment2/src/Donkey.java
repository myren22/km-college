//Kyle 100%. Never ended up contacting partner in project.

public class Donkey extends AbstractMover implements Driver{
	
	
	public Donkey(int force)
	{
		super(force);
	}
	
	@Override
	public boolean equals(Object otherDonkey){
		if(otherDonkey instanceof Donkey)
		{
			int otherForce = ((Donkey)otherDonkey).getForce();
			if(otherForce == getForce())
			{
				return true;
			}
		}
		return false;
	}
}
