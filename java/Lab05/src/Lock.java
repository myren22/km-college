
public class Lock{
	public int upperLimit;
	public boolean isOpen;
	protected Combination theCombo;
	
	
	public Lock(int upperLimit, Combination theCombo){
		
			if(!theCombo.isWithinRange(upperLimit))
				throw new InvalidLockCombinationException();
		
			this.upperLimit = upperLimit;
			this.theCombo = theCombo;
			this.isOpen = true;
		
	}
	
	public int getDialLimit(){
		return upperLimit;
	}
	
	public void open(Combination tryCombination){
		//equals
		if(theCombo.equals(tryCombination)){
			this.isOpen = true;
		}
	}
	public void close()
	{
		this.isOpen = false;
	}
	
	public boolean isOpen(){
		return this.isOpen;
	}
}
