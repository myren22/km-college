
/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car
{
    
    private Person driver;
    private Person[] passengers;
    

    /**
     * Constructor for objects of class Car
     */
    public Car()
    {
        passengers = new Person[4];
    }
    public Car(int aCapacity)
    {
        if(aCapacity <= 4)
        {
            passengers = new Person[4];
        }
        else if(aCapacity >= 8)
        {
            passengers = new Person[8];
        }
        else
        {
            passengers = new Person[aCapacity];
        }
    }
    public int getCapacity()
    {
        return passengers.length;
    }
    public int getOccupancy()
    {
        int count = 0;
        for(int i = 0; i<passengers.length; i++)
        {
            if(passengers[i] != null)
            {
                count = count + 1;
            }
        }
        return count;
    }
    public boolean hasRoom()
    {
        if(getCapacity()>getOccupancy())
        {
            return true;
        }
        return false;
        /*
        for(int i = 0; i<passengers.length; i++)
        {
            if(passengers[i]==null)
            {
                return true;
            }
        }
        return false;
        */
    }
    
    public Person getDriver()
    {
        return driver;
    }
    public boolean setDriver(Person person)
    {
        //can   become  a   passenger
        //previous driver become passenger  
        if(canDrive(person))
        {
            if(hasPassenger(person))
            {
                driver = person;
                return true;
            }
            else if(hasRoom())
            {
                driver = person;
                addPassenger(person);
                return true;
            }
        }
        
        return false;
    }
    public Person[] getPassengers()
    {
        //create a copy of passenger array and then return that
        Person[] passengerCopy = new Person[passengers.length];
        for(int i=0; i<passengers.length; i++)
        {
            passengerCopy[i] = passengers[i];
        }
        return passengerCopy;
    }
    public boolean hasPassenger(Person person)
    {
        if(person==null) return false;
        for(int i=0; i<passengers.length; i++)
        {
            if(person==passengers[i])
            {
                return true;
            }
        }
        return false;
    }
    public boolean addPassenger(Person person)
    {
        //fails if person to add is “null”, if the person is a passenger already,
        //or if there is no room left in the car to add it
        if((person == null)||!hasRoom() || hasPassenger(person)  )
        {
            return false;
        }
        
        for(int i=0; i<passengers.length; i++)
        {
            if(passengers[i] == null)
            {
                passengers[i] = person;
                return true;
            }
        }
        return false;
    }
    public boolean removePassenger(Person person)
    {
        if(person == null)
        {
            return false;
        }
        if(driver == person)
        {
            driver = null;
        }
        for(int i=0; i<passengers.length; i++)
        {
            if((passengers[i] == person))
            {
                
                passengers[i] = null;
                return true;
            }
        }
        return false;
    }
    public boolean canDrive(Person person)
    {
        boolean x = false;
        if(person == null)
        {
            return false;
        }
        if (person.getAge() >= 16) 
        {
            x = true;
        }
        return x;
    }
    
}
