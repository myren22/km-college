import static org.junit.Assert.*;

import org.junit.Test;


public class BSTreeOurTest {

	@Test
	public void testNode() {
		BSTNode<String> aNode1 = new BSTNode<String>("node1",null,null);
		BSTNode<String> aNode2 = new BSTNode<String>("node2",null,null);
		BSTNode<String> aNode3 = new BSTNode<String>("node3",null,null);
		
		
		assertEquals("not equals", "node1", aNode1.getValue());
		
		aNode1.setValue("changed");
		assertEquals("not equal","changed", aNode1.getValue() );
		
		aNode1.setLeft(aNode2);
		assertEquals("not equal",aNode2, aNode1.getLeft() );
		aNode1.setRight(aNode3);
		assertEquals("not equal",aNode3, aNode1.getRight() );
		
		BSTNode<String> aNode4 = new BSTNode<String>("node3", aNode2,aNode1);
		assertEquals("not equal",aNode2, aNode4.getLeft() );
		assertEquals("not equal",aNode1, aNode4.getRight() );	
	}
	
	@Test
	public void testTreeInt() {
		BSTree<Integer> aTree= new BSTree<Integer>();
		
		assertTrue(aTree.isEmpty());
		
		BSTNode<Integer> hiNode = new BSTNode<Integer>(0, null, null); 
		
		aTree.insert(1);
//		assertEquals("adsf", true, aTree.find(1));
//		assertEquals("adsf", hiNode, aTree.findNode(1));
		
		aTree.insert(6);
//		aTree.insert(1);
		aTree.insert(2);
		aTree.insert(3);
		aTree.insert(4);
		assertTrue(aTree.find(1));
		assertTrue(aTree.find(6));
		aTree.delete(1);
		assertFalse(aTree.find(1));
	}
	
	@Test
	public void testTreeIntDelete() {
		BSTree<Integer> aTree= new BSTree<Integer>();
		
		assertTrue(aTree.isEmpty());
		
		aTree.insert(1);
		aTree.insert(2);
		aTree.insert(3);
		aTree.insert(4);
		aTree.delete(1);
		assertFalse(aTree.find(1));	
		
		
	}

	@Test
	public void testTreeIntDelete2() {
		BSTree<Integer> aTree= new BSTree<Integer>();
		
		assertTrue(aTree.isEmpty());
		

		aTree.delete(1);
		assertFalse(aTree.find(1));	
		
		aTree.insert(10);
		aTree.insert(5);
		aTree.insert(13);
		aTree.insert(3);
		aTree.insert(7);
		aTree.insert(15);
		
//		System.out.print(aTree.iteratorPreorder());
		
		aTree.delete(3);
		assertFalse(aTree.find(3));
		
		aTree.delete(13);
		assertFalse(aTree.find(13));
		

		aTree.delete(10);
		assertFalse(aTree.find(10));
		
		aTree.delete(7);
		aTree.delete(15);
		aTree.delete(5);
		assertFalse(aTree.find(5));
		assertFalse(aTree.find(15));
		assertFalse(aTree.find(7));
//		System.out.print(aTree.iterator());
		assertTrue(aTree.isEmpty());		
		
	}
	
	@Test
	public void testTreeCharDelete3() {
		BSTree<Character> aTree= new BSTree<Character>();
		
		assertTrue(aTree.isEmpty());
	
		aTree.insert('F');
		aTree.insert('H');
		aTree.insert('G');
		aTree.insert('J');
		aTree.insert('I');
		aTree.insert('B');
		
		aTree.insert('A');
		aTree.insert('D');
		aTree.insert('C');
		aTree.insert('E');
		
		BSTree<Integer> tree = new BSTree<Integer>();
		tree.insert(1);
		tree.insert(2);
		assertEquals("",tree.findParent(2),1);
		
		aTree.delete('G');
		assertFalse(aTree.find('G'));
		
		aTree.delete('H');
		assertFalse(aTree.find('H'));
		

		aTree.delete('F');
		assertFalse(aTree.find('F'));
		


		assertFalse(aTree.isEmpty());		
		
	}



}
