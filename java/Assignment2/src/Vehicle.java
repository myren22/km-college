//Kyle 100%. Never ended up contacting partner in project.

public abstract class Vehicle {
	private Mover mover;
	private Driver driver;
	
	public Vehicle(Driver driver, Mover mover){
		this.setMover(mover);
		this.setDriver(driver);
	}

	public Mover getMover(){
		return mover;
	}
	
	public Driver getDriver(){
		return driver;
	}
	
	public void setMover(Mover mover){
		this.mover = mover;
	}
	
	public void setDriver(Driver driver){
		this.driver = driver;
	}
	
	@Override
	public boolean equals(Object otherVehicle){
		if(otherVehicle instanceof Vehicle)
		{
			Mover otherMover = ((Vehicle)otherVehicle).getMover();
			if(otherMover.equals(mover))
			{
				return true;
			}
		}
		return false;
	}
	
}
