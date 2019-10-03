import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.Test;

public class PetTest {

	@Test
	public void testHierarchy() {
		Object pet = new Pet( "?" );
		Object cat = new Cat( "/" );
		Object dog = new Dog( "*" );
		
		assertFalse( "Incorrect result", pet instanceof Cat );
		assertFalse( "Incorrect result", pet instanceof Dog );
		
		assertTrue ( "Incorrect result", cat instanceof Pet );
		assertFalse( "Incorrect result", cat instanceof Dog );
		
		assertTrue ( "Incorrect result", dog instanceof Pet );
		assertFalse( "Incorrect result", dog instanceof Cat );
	}
	@Test
	public void testReflection_Pet() {
		Class<?>   petClass      = Pet.class;
		Class<?>[] petInterfaces = petClass.getInterfaces();
		Field[]    petFields     = petClass.getDeclaredFields();
		assertEquals( "Pet doesn't implement an interface",   1,                      petInterfaces.length );
		assertEquals( "Pet doesn't implement this interface", "java.lang.Comparable", petInterfaces[0].getName() );

		int count = 0;
		for (Field f : petFields) {
			if (!f.isSynthetic()) {
				assertTrue ( "Field \""+f.getName()+"\" should be private", Modifier.isPrivate( f.getModifiers() ));
				assertFalse( "Field \""+f.getName()+"\" can't be static",   Modifier.isStatic ( f.getModifiers() ));
				count++;
			}
		}
		assertEquals( "Pet should have one field",            1, count );
		assertTrue  ( "Pet's only field should be private",   Modifier.isPrivate( petFields[0].getModifiers() ));
		assertFalse ( "Pet's only field cannot be static",    Modifier.isStatic ( petFields[0].getModifiers() ));
	}
	@Test
	public void testReflection_Dog() {
		Class<?>   dogClass      = Dog.class;
		Class<?>[] dogInterfaces = dogClass.getInterfaces();
		Field[]    dogFields     = dogClass.getDeclaredFields();
		assertEquals( "Dog shouldn't implement an interface", 0, dogInterfaces.length );

		int count = 0;
		for (Field f : dogFields) {
			if (!f.isSynthetic()) {
				count++;
			}
		}
		assertEquals( "Dog should not have any fields",       0, count );
		
		for (Method dogMethod : dogClass.getMethods()) {
			if (dogMethod.getDeclaringClass() == dogClass) {
				String name = dogMethod.getName();
				if (name.contains("toString")) {
					fail( "Dog should not implement toString()" );
				}
			}
		}
		boolean dogEquals = false;
		for (Method dogMethod : dogClass.getMethods()) {
			if (dogMethod.getDeclaringClass() == dogClass) {
				String name = dogMethod.getName();
				if (name.contains("equals")) {
					dogEquals = true;
					break;
				}
			}
		}
		assertTrue( "Dog should override the equals method", dogEquals );
	}
	@Test
	public void testReflection_Cat() {
		Class<?>   catClass      = Cat.class;
		Class<?>[] catInterfaces = catClass.getInterfaces();
		Field[]    catFields     = catClass.getDeclaredFields();
		assertEquals( "Cat shouldn't implement an interface", 0, catInterfaces.length );

		int count = 0;
		for (Field f : catFields) {
			if (!f.isSynthetic()) {
				count++;
			}
		}
		assertEquals( "Cat should not have any fields",       0, count );

		for (Method catMethod : catClass.getMethods()) {
			if (catMethod.getDeclaringClass() == catClass) {
				String name = catMethod.getName();
				if (name.contains("toString")) {
					fail( "Cat should not implement toString()" );
				}
			}
		}
		boolean catEquals = false;
		for (Method catMethod : catClass.getMethods()) {
			if (catMethod.getDeclaringClass() == catClass) {
				String name = catMethod.getName();
				if (name.contains("equals")) {
					catEquals = true;
					break;
				}
			}
		}
		assertTrue( "Cat should override the equals method", catEquals );
	}
	@Test
	public void testPet() {
		Random   random   = new Random();
		String[] names    = { "foo", "bar", "blah" };
		String   name     = names[ random.nextInt( names.length )];
		Pet      pet      = new Pet( name );
		String   expected = name;
		String   actual   = pet.toString();
		
		assertEquals( "Incorrect result", expected, actual );
	}

	@Test
	public void testToString() {
		String expected, actual;
		// cat
		Cat cat  = new Cat( new String( "Meow" ));
		expected = "Meow";
		actual   = cat.toString();

		assertEquals( "Incorrect result", expected, actual );
		
		// dog
		Dog dog  = new Dog( new String( "Buster" ));
		expected = "Buster";
		actual   = dog.toString();
		
		assertEquals( "Incorrect result", expected, actual );
	}
	@Test
	public void testEquals() {
		Object a, b;
		// same objects
		a = new Pet( "boing" );
		assertTrue ( "Incorrect result", a.equals( a ));
		
		a = new Dog( "fuzz" );
		assertTrue ( "Incorrect result", a.equals( a ));
		
		a = new Cat( "ping" );
		assertTrue ( "Incorrect result", a.equals( a ));

		// different objects, same type, same name
		a = new Pet( new String( "boing" ));
		b = new Pet(             "boing" );
		assertTrue ( "Incorrect result", a.equals( b ));
		
		a = new Dog( new String( "fuzz" ));
		b = new Dog(             "fuzz" );
		assertTrue ( "Incorrect result", a.equals( b ));
		
		a = new Cat( new String ( "ping" ));
		b = new Cat(              "ping" );
		assertTrue ( "Incorrect result", a.equals( b ));

		// different objects, different types, same name
		a = new Pet( "boing" ) { };
		b = new Cat( "boing" ) { };
		assertTrue ( "Incorrect result", a.equals( b ));
		assertFalse( "Incorrect result", b.equals( a ));
		
		a = new Pet( "zing" ) { };
		b = new Dog( "zing" ) { };
		assertTrue ( "Incorrect result", a.equals( b ));
		assertFalse( "Incorrect result", b.equals( a ));
		
		a = new Cat( "ding" ) { };
		b = new Dog( "ding" ) { };
		assertFalse( "Incorrect result", a.equals( b ));
		assertFalse( "Incorrect result", b.equals( a ));

		// different objects, different types, different names
		a = new Pet( "ba-da-bum" );
		b = new Cat( "puff" );
		assertFalse( "Incorrect result", a.equals( b ));
		assertFalse( "Incorrect result", b.equals( a ));
		
		a = new Pet( "gazam" );
		b = new Dog( "gazax" );
		assertFalse( "Incorrect result", a.equals( b ));
		assertFalse( "Incorrect result", b.equals( a ));
		
		a = new Cat( "ba-ding" );
		b = new Dog( "ba-dong" );
		assertFalse( "Incorrect result", a.equals( b ));
		assertFalse( "Incorrect result", b.equals( a ));
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testSort() {
		ArrayList<Comparable> list = new ArrayList<Comparable>();
		Object                dog  = new Dog( "bar" );
		Object                cat  = new Cat( "foo" );
		
		list.add( (Comparable)cat );
		list.add( (Comparable)dog );
		list.add( (Comparable)cat );
		list.add( (Comparable)dog );
		list.add( (Comparable)dog );
		
		Collections.sort( list );
		
		assertEquals( "Incorrect result", dog, list.get( 0 ));
		assertEquals( "Incorrect result", dog, list.get( 1 ));
		assertEquals( "Incorrect result", dog, list.get( 2 ));
		assertEquals( "Incorrect result", cat, list.get( 3 ));
		assertEquals( "Incorrect result", cat, list.get( 4 ));
	}
}