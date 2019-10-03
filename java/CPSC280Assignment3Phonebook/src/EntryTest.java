

//Kyle Myren 60%, Jackie Gray 40%


import static org.junit.Assert.*;

import org.junit.Test;

public class EntryTest {

	@Test
	public void testEntry() {
		Entry anEntry = new Entry("kyle", "123-123-123", true, true);
		Entry anEntry2 = new Entry("kyle", "123-123-123", false, true);
		
		assertEquals("should return kyle", "kyle", anEntry.getName());
		assertEquals("should return 123-123-123", "123-123-123", anEntry.getPhone());
		assertTrue("number is home", anEntry.isHome());
		assertTrue("number is work", anEntry.isWork());
		
		assertFalse("number is home", anEntry2.isHome());
		assertTrue("number is work", anEntry2.isWork());
	}
	@Test
	public void testEquals() {
		Entry anEntry = new Entry("kyle", "123-123-123", true, true);
		Entry anEntry2 = new Entry("kyle", "123-123-123", false, true);
		Entry anEntry3 = new Entry("kyle", "123-123-123", true, true);
		

		assertFalse("different entries", anEntry.equals(anEntry2));
		assertTrue("same entries", anEntry.equals(anEntry3));
		
		

	}

}
