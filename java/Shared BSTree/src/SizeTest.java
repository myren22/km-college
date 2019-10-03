import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class SizeTest {
	// private stuff: building a node
	private static <T extends Comparable<? super T>> TNode<T> buildTree(T[] array) {
		return buildTree( 0, array );
	}
	private static <T extends Comparable<? super T>> TNode<T> buildTree(int index, T[] array) {
		TNode<T> node = null;
		if (index < array.length && array[index] != null) {
			node       = new TNode<T>( array[index] );
			node.left  = buildTree( (2* index)+1,  array );
			node.right = buildTree(  2*(index +1), array );
		}
		return node;
	}
	
	// tests
	@Test
	public void testNoStaticNoNonPrivateFieldsAllowed() {
		Field[] iFields = (Size.class).getDeclaredFields();

		for (Field f : iFields) {
			if (!f.isSynthetic()) {
				assertTrue ( "Field \""+f.getName()+"\" should be private", Modifier.isPrivate( f.getModifiers() ));
				assertFalse( "Field \""+f.getName()+"\" can't be static",   Modifier.isStatic ( f.getModifiers() ));
			}
		}
	}
	@Test
	public void testEmptyTree() {
		TNode<Integer> node   = buildTree( new Integer[]{ } );
		int            actual = Size.getSize( node );
		assertEquals( "", 0, actual );
	}
	@Test
	public void testTreeOf1() {                         //   0
		TNode<Integer> node   = buildTree( new Integer[]{   42 } );
		int            actual = Size.getSize( node );
		assertEquals( "", 1, actual );
	}
	@Test
	public void testTreeOf3Balanced() {                 //   0     1     2
		TNode<Integer> node   = buildTree( new Integer[]{   42,   21,   84 } );
		int            actual = Size.getSize( node );
		assertEquals( "", 3, actual );
	}
	@Test
	public void testTreeOf4DegenerateLeft() {           //   0     1     2     3     4     5     6     7
		TNode<Integer> node   = buildTree( new Integer[]{    4,    3, null,    2, null, null, null,    1 } );
		int            actual = Size.getSize( node );
		assertEquals( "", 4, actual );
	}
	@Test
	public void testTreeOf4DegenerateRight() {          //   0     1     2     3     4     5     6     7     8     9    10    11    12    13    14
		TNode<Integer> node   = buildTree( new Integer[]{    4, null,    3, null, null, null,    2, null, null, null, null, null, null, null,    1 } );
		int            actual = Size.getSize( node );
		assertEquals( "", 4, actual );
	}
	@Test
	public void testTreeOfSeveral() {                   //   0     1     2     3     4     5     6     7     8     9    10    11    12    13
		TNode<Integer> node   = buildTree( new Integer[]{    1,    2,    3,    4,    5,    6,    7, null, null, null, null, null,    8,    9 } );
		int            actual = Size.getSize( node );
		assertEquals( "", 9, actual );
	}
}