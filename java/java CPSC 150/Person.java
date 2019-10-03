
/**
 * Write a description of class Person here.
 * 
 * @Andrew Fournier (your name) 
 * @041514 (a version number or a date)
 */
public class Person {
    
    String PersonName;
    int age;
    
    public Person() {
        PersonName = "no name";
        age = 0;
    }
    
    public Person(String aName, int anAge) {
        PersonName = aName;
        age = anAge;
    }
    
    public String getName() {
        return PersonName;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int anAge) {
        age = anAge;
        if (anAge < 0) {
            anAge = 0;
        }
    }
    
    public void setName(String aName) {
        PersonName = aName;
    }
    
    public boolean canDrive() {
        if (age >= 16) {
            return true;
        }
        return false;
    }
    
    public static boolean canDrive(int age) {
        boolean x = false;
        if (age >= 16) {
            x = true;
        }
        return x;
    }
}
