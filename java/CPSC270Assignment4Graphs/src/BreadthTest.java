import static org.junit.Assert.*;

import org.junit.Test;


public class BreadthTest {
	@Test
	public void testBreadth() {
		Vertex<Character> a = new Vertex('A');
		Vertex<Character> b = new Vertex('B');
		Vertex<Character> c = new Vertex('C');
		Vertex<Character> d = new Vertex('D');
		Vertex<Character> e = new Vertex('E');
		Vertex<Character> f = new Vertex('F');
		
		a.add(b).add(e);
		b.add(a).add(c);
		c.add(b).add(d);
		d.add(e).add(f);
		e.add(a).add(d);
		f.add(d);
		
		Character[] actual = (Character[])Breadth.getList(a);
		//is this right?
		/*
		 * 		a-------b
		 * 		|		|
		 * 		|		|
		 * 		e		|
		 * 		| f		|
		 * 		|/		|
		 * 		d-------c
		 */
//		Character[] test = new Character[2];
		Character[] expected = new Character[]{'A','B','E','C','D','F'};
		assertArrayEquals("", expected, actual);
	}
}
