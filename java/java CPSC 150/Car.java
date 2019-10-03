
/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car
{
    
    private int capacity;
    private int occupancy;
    

    /**
     * Constructor for objects of class Car
     */
    public Car()
    {
        this.capacity = 4;
    }
    public Car(int aCapacity)
    {
        if(aCapacity <= 4)
        {
            this.capacity = 4;
        }
        else if(aCapacity >= 8)
        {
            this.capacity = 8;
        }
        else
        {
            this.capacity = aCapacity;
        }
    }
    public int getCapacity()
    {
        return capacity;
    }
    public int getOccupancy()
    {
        return occupancy;
    }
    public boolean hasRoom()
    {
        if(occupancy>= capacity)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Person getDriver()
    {
        return driver;
    }
    public boolean setDriver(Person person)
    {
        person 
        driver = person;
    }
    public Person[] getPassengers()
    {
        
    }
    public boolean hasPassenger(Person person)
    {
        
    }
    public boolean addPassenger(Person person)
    {
        
    }
    public boolean removePassenger(Person person)
    {
        
    }
    public boolean canDrive(Person person)
    {
        boolean x = false;
        if (age >= 16) 
        {
            x = true;
        }
        return x;
    }
    
}
