
public class BSTNode<T extends java.lang.Comparable<? super T>> extends java.lang.Object{
	private T value;
	private BSTNode<T> left;
	private BSTNode<T> right;
	
	public BSTNode(T value, BSTNode<T> left, BSTNode<T> right)
	{
		this.value = value;
		this.left = left;
		this.right = right;
	}
	//Create a node from the given parameters.
	
	
	public T getValue(){
		return this.value;
	}
//	Get the value of this node.
	
	
	public void setValue(T value){
		this.value = value;
	}
//	Set the value to the given parameter.

	
	public BSTNode<T> getLeft(){
		return left;
	}

	
	public void setLeft(BSTNode<T> left){
		this.left = left;
	}
//	Set the left child.
	
	
	public BSTNode<T> getRight(){
		return right;
	}
//	Get the right child.
	
	
	public void setRight(BSTNode<T> right){
		this.right = right;
	}
//	Set the right to the given parameter.
	
	public void add(T value){
		//check duplicate
		if(0 == this.value.compareTo(value)){
			throw new IllegalArgumentException();
		}
		if(0 < this.value.compareTo(value)){
			if(left==null){
				left = new BSTNode(value, null, null);
			}
			else{
				left.add(value);
			}
		}
		if(0 > this.value.compareTo(value)){
			if(right == null){
				right = new BSTNode(value, null, null);
			}
			else{
				right.add(value);
			}
		}
	}
	
}
