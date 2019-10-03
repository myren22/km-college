//Kyle 100%. Never ended up contacting partner in project.

public class Person extends AbstractMover implements Driver{
	
	
	public Person(int force)
	{
		super(force);
	}
	
	@Override
	public boolean equals(Object otherPerson){
		if(otherPerson instanceof Person)
		{
			int otherForce = ((Person)otherPerson).getForce();
			if(otherForce == getForce())
			{
				return true;
			}
		}
		return false;
	}
}
