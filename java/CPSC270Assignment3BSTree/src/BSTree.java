import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class BSTree <T extends java.lang.Comparable<? super T>>
extends java.lang.Object
implements java.lang.Iterable<T>{
	private int size;
	private BSTNode<T> root;
	
	public BSTree(){
		root = null;
	}
//	Create an empty BSTree. An empty BSTree is indicated by a null root.
	
	
	public boolean isEmpty(){
		if(root == null){
			return true;
		}
		else{
			return false;
		}
	}
//	Report if this tree is empty.
	
	
	
	public void insert(T value){
		if(root == null){
			root = new BSTNode(value,null,null);
		}
		else{
			root.add(value);
		}
		
	}
//	Insert the given parameter into this tree. The BST property must be preserved by this operation. 
//	Remember that duplicates are NOT allowed, in which case, an IllegalArgumentException must be thrown.
	
	
	public boolean find(T value){
		BSTNode<T> current = root;
		while(current!=null){
			T curValue = current.getValue();
			if(0== curValue.compareTo(value)){
				return true;
			}
			else if(0 > curValue.compareTo(value)){
				current = current.getRight();
			}
			else{
				current = current.getLeft();
			}
		}
		return false;
	}
//	Find out if the given parameter is in the tree.
	
	
//	else if(-1 == curValue.compareTo(value)){
//		current = current.getLeft();
//	}
//	else{
//		current = current.getRight();
//	}
	
	
	public BSTNode<T> findNode(T value){
		BSTNode<T> current = root;
		while(current!=null){
			T curValue = current.getValue();
			if(0== curValue.compareTo(value)){
				return current;
			}
			else if(0> curValue.compareTo(value)){
				current = current.getRight();
			}
			else{
				current = current.getLeft();
			}
		}
		//throw exception
		throw new IllegalArgumentException("findNode Exception");
	}
	public BSTNode<T> findParent(T value){
		BSTNode<T> current = root;
		BSTNode<T> previous =null ;
		while(current != null){
			T curValue = current.getValue();
			if(0 == curValue.compareTo(value)){
				return previous;
			}
			else if(0 > curValue.compareTo(value)){
				previous = current;
				current = current.getLeft();
			}
			else{
				previous = current;
				current = current.getRight();
			}
		}
		//throw exception
		throw new IllegalArgumentException("findParent Exception");
	}
	
	
	public void delete(T value){
		BSTNode<T> nodeWithVal = null;
		BSTNode<T> parent = null;
		BSTNode<T> current = root;
		

		//cycle through and assign values to parent & nodeWithVal.
		while(current != null){
			if(value.compareTo(current.getValue()) == 0){
				//found node to delete
				nodeWithVal = current;
				break;
			}
			else if(value.compareTo(current.getValue()) > 0){
				parent = current;
				current = current.getRight();
			}
			else{
				parent = current;
				current = current.getLeft();
			}
			
		}
//		if value wasn't found, throw exception
		if(nodeWithVal == null){
			return;
		}
		
		//count children
		int children=0;
		if(current.getLeft() != null){
			children++;
		}
		if(current.getRight() != null){
			children++;
		}
		
		//check that targetted node is the root
		if(root.getValue() == value){
			if(children == 0){
				root = null;
			}
			else if(children == 1){
				if(nodeWithVal.getLeft() == null){
					root = nodeWithVal.getRight();
				}
				else{
					root =nodeWithVal.getLeft();
				}
			}
			else{
				BSTNode<T> rightMostOfLeft = nodeWithVal.getLeft();
				while(rightMostOfLeft.getRight() != null){
					rightMostOfLeft = rightMostOfLeft.getRight();
				}
				delete(rightMostOfLeft.getValue());
				rightMostOfLeft.setLeft(nodeWithVal.getLeft());
				rightMostOfLeft.setRight(nodeWithVal.getRight());	
				root = rightMostOfLeft;
			}			
		}
		//not the root node
		else{
			boolean isLeft = (nodeWithVal == parent.getLeft() );
			
			if(children == 0){
				if(isLeft){
					parent.setLeft(null);
				}
				else{
					parent.setRight(null);
				}
			}
			else if(children == 1){
				if(isLeft){
					if(nodeWithVal.getLeft() == null){
						parent.setLeft(nodeWithVal.getRight());
					}
					else{
						parent.setLeft(nodeWithVal.getLeft());
					}
				}
				else{
					if(nodeWithVal.getLeft() == null){
						parent.setRight(nodeWithVal.getRight());
					}
					else{
						parent.setRight(nodeWithVal.getLeft());
					}
				}
			}
			else{
				if(isLeft){
					BSTNode<T> rightMostOfLeft = nodeWithVal.getLeft();
					while(rightMostOfLeft.getRight() != null){
						rightMostOfLeft = rightMostOfLeft.getRight();
					}
					delete(rightMostOfLeft.getValue());
					rightMostOfLeft.setLeft(nodeWithVal.getLeft());
					rightMostOfLeft.setRight(nodeWithVal.getRight());	
					parent.setLeft(rightMostOfLeft);
				}
				else{
					BSTNode<T> rightMostOfLeft = nodeWithVal.getLeft();
					while(rightMostOfLeft.getRight() != null){
						rightMostOfLeft = rightMostOfLeft.getRight();
					}
					delete(rightMostOfLeft.getValue());					
					rightMostOfLeft.setLeft(nodeWithVal.getLeft());
					rightMostOfLeft.setRight(nodeWithVal.getRight());
					parent.setRight(rightMostOfLeft);
				}
				
			}
		}
		
		
		

		

		//-----------------------------------
		
//		//if no children, replace ref to node as null
//		if(children == 0){
//			root = null;
//		}
//		
//		//if one child link over
//		if(children == 1){
//			if(current.getLeft() == null){
//
//				current = current.getRight();
//			}
//			else{
//				current = current.getLeft();
//			}
//		}
//		//if two children replace with highest predecessor
//		if(children == 2){
//			//if first left has open right
//			BSTNode<T> left = current.getLeft();
//			if(left.getRight() == null){
//				left.setRight(current.getRight());
//			}
//			//find the right most node in left tree. 
//			//remove from its position and make all it point to currents children
//			else{
//				BSTNode<T> rightMost = left;
//				while(rightMost.getRight() != null){
//					rightMost = rightMost.getRight();
//				}
//				delete(rightMost.getValue());
//				rightMost.setLeft(current.getLeft());
//				rightMost.setRight(current.getRight());
//			}
//		}
		
		//if delete can't be performed - Throw IllegalArgumentException
	}
//	Delete the given value from this tree. Since this is a delete operation,
//	if the delete can't be performed then the tree should be left unchanged
//	and NO IllegalArgumentException is to be thrown.
//	It is up to you to determine the various cases for deleting a value from a tree.
	
	public java.util.Iterator<T> iterator(){
		Iterator<T> preIt = new IteratorPreorder();
		return preIt;
	}
//	Returns an iterator over elements of type T. The default iteration type is in-order.
	
	public java.util.Iterator<T> iteratorPreorder(){
		Iterator<T> preIt = new IteratorPreorder();
		return preIt;
	}
//	Returns a pre-order iterator over elements of type T.
	
	public java.util.Iterator<T> iteratorInorder(){
		Iterator<T> inIt = new IteratorInorder();
		return inIt;
	}
//	Returns an in-order iterator over elements of type T.
	
	public java.util.Iterator<T> iteratorPostorder(){
		Iterator<T> postIt = new IteratorPostorder();
		return postIt;
	}
//	Returns a post-order iterator over elements of type T.
	
	
	
	public java.util.Iterator<T> iteratorLevelorder(){
		Iterator<T> levelIt = new IteratorLevelorder();
		return levelIt;
	}
//	Returns an level-order iterator over elements of type T.
	
//	public void print(){
//		BSTNode<T> node = root;
//	    if(node != null){
//	       System.out.print(root.getValue());
//	       print(node.getLeft());
//	       print(node.getRight());
//	    }
//	}
	
	public boolean equals(java.lang.Object obj){
		if(obj instanceof BSTree)
		{
			BSTree <T> newOne = (BSTree<T>) obj;
			return Equals(this.root,newOne.root);
		}
		return false;
	}
	public boolean Equals(BSTNode<T> first, BSTNode <T> second)
	{
		boolean answer = false;
		if((first == null) && (second == null))
		{
			return true;
		}
		else if((first == null) || (second == null))
		{
			return false;
		}
		else if((first.getValue() == second.getValue()))
		{
			return true;
		}
		else if(!(first.getValue().equals(second.getValue())))
		{
			return false;
		}
		else if(((first.getRight()!=null) || (first.getLeft()!=null)) && ((second.getLeft()!=null) && (second.getRight()!= null)))
				{
			return false;
				}
		else if(((second.getRight()!=null) || (second.getLeft()!=null)) && ((first.getLeft()!=null) && (first.getRight()!= null)))
				{
			return false;
				}
		else
		{
			return (Equals(first.getRight(),first.getLeft()) && Equals(second.getRight(),second.getLeft()));
		}
	}
//	Indicates whether some other object is "equal to" this one. 
//	Two BSTrees are equal if they are the same object or if they have the exact number of elements and values. 
//	You can use iterators to traverse the contents of trees when comparing their values.
	
	
	private class IteratorPreorder implements Iterator<T> {

		private  Queue<T> queue;
		
		public IteratorPreorder(){
			queue = new LinkedList<T>();
			preOrder(root);
		}
		
		@Override
		public boolean hasNext(){
			return !queue.isEmpty();

		}

		@Override
		public T next() {			
			return queue.remove();
		}
		
		private void preOrder(BSTNode<T> node){
			if(node != null){
				queue.offer(node.getValue());
				preOrder(node.getLeft());
				preOrder(node.getRight());
			}
		}
		
	}
	private class IteratorInorder implements Iterator<T> {

		private  Queue<T> queue;
		
		public IteratorInorder(){
			queue = new LinkedList<T>();
			inOrder(root);
		}
		
		@Override
		public boolean hasNext(){
			return !queue.isEmpty();

		}

		@Override
		public T next() {			
			return queue.remove();
		}
		
		private void inOrder(BSTNode<T> node){
			if(node != null){				
				inOrder(node.getLeft());
				queue.offer(node.getValue());
				inOrder(node.getRight());
			}
		}
		
	}
	
	private class IteratorPostorder implements Iterator<T> {

		private  Queue<T> queue;
		
		public IteratorPostorder(){
			queue = new LinkedList<T>();
			postOrder(root);
		}
		
		@Override
		public boolean hasNext(){
			return !queue.isEmpty();

		}

		@Override
		public T next() {			
			return queue.remove();
		}
		
		private void postOrder(BSTNode<T> node){
			if(node != null){				
				postOrder(node.getLeft());
				postOrder(node.getRight());
				queue.offer(node.getValue());
			}
		}
		
	}
	
	private class IteratorLevelorder implements Iterator<T> {

		private  Queue<T> queue;
		
		public IteratorLevelorder(){
			queue = new LinkedList<T>();
			levelOrder(root);
		}
		
		@Override
		public boolean hasNext(){
			return !queue.isEmpty();

		}

		@Override
		public T next() {			
			return queue.remove();
		}

		private void levelOrder(BSTNode<T> node){
			Queue<BSTNode<T>> queueLoop = new LinkedList<>();	
			queueLoop.offer(node);	
			while(!queueLoop.isEmpty())	{	
				node= queueLoop.remove();	
				queue.offer( node.getValue());	
				if(node.getLeft() !=null){	
					queueLoop.offer(node.getLeft());	
				}
				 if(node.getRight()!=	null){
					 queueLoop.offer(node.getRight());	
				 }
			}	
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
