package poop;

public class Node<T> extends java.lang.Object {
    
    protected T val;
    protected Node<T> next;
    
    public Node(T myVal, Node<T> myRef)
    {
        this.val = myVal;
        this.next = myRef;
    }
    public Node(T newItem)
    {
        val = newItem;
        next = null;
    }
    public String toString(){
    	return val.toString();
    }

}
