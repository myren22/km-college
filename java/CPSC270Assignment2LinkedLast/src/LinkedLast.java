//Kyle Myren 100%, alex noak worked independently 


import java.util.ArrayList;
import java.util.LinkedList;



public class LinkedLast<T>
extends java.lang.Object
implements java.lang.Iterable<T>{
	private Node<T> last = null;
	private int size = 0;
	
	
	public void add(int index, T o){
		//adds a value at specified index
		if(index>size || index<0){
			throw new IndexOutOfBoundsException();
		}
		Node<T> addedNode = new Node<T>(o);
		Node<T> current = last.next;
		for(int i=0; i<index-1; i++){
			current = current.next;
		}
		addedNode.next = current.next;
		current.next = addedNode;
		size++;		
	}
	
	public void add(T o){
		//adds a value to the end of the list
		Node<T> addedNode = new Node<T>(o, null);
		Node<T> currentLast = last;
		if(size==0){
			
			currentLast = addedNode;
			addedNode.next = addedNode;
			last = addedNode;
		}
		else{

			//Node<T> addedNode = new Node<T>(o, currentLast.next);
			addedNode.next = currentLast.next;
			currentLast.next = addedNode;
			last = addedNode;
		}
		
		size++;
	}
	
	public void clear(){
		//removes all values in the list
		this.size=0;
		this.last.value = null;
		this.last.next = null;		
		//make last point to null. garbage collector takes care of rest
	}
	
	public boolean contains(T o){
		//indicates whether a value is in the list
		
		Node<T> current = last.next;
		for(int i=0; i<size; i++){
			if(current.value == o){
				return true;
			}
			current = current.next;
		}
		return false;
	}
	

	
	public T get(int index){
		//returns the value at specified index
		//check if index is within size of array
		if(index>=size || index<0){
			throw new IndexOutOfBoundsException();
		}
		Node<T> current = last.next;
		for(int i=0; i<index; i++){
			current = current.next;
		}
		return current.value;
	}
	
	public int getSize(){
		//returns the numbers of values in the list
		return size;
	}
	
	public int indexOf(T o){
		//returns the index of the specified value
		Node<T> current = last.next;
		for(int i=0; i<size; i++){
			if(current.value == o){
				return i;
			}
			current = current.next;
		}
		
		return -1;	//if cycled through without finding value
	}
	
	public boolean isEmpty(){
		//indicates whether the list stores any values
		if(this.size==0){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public boolean equals(java.lang.Object obj){
		//determine if this list is equal to the given list
		
		if(obj instanceof LinkedLast){
			LinkedLast<T> boom = (LinkedLast<T>) obj;
			if(size != boom.getSize()){
				return false;
			}
			for(int i=0; i<size; i++){
				//if(!last.value.equals(boom.value)){
				if(!this.get(i).equals(boom.get(i))){
					return false;
				}
			}
		}
		return true;
	}
	
	public java.util.Iterator<T> iterator(){
		return this.iterator();
		//returns an iterator to iterate over the list of elements
		
	}
	public T remove(int index){
		//removes the value at specified index
		if(index>=size || index<0){
			throw new IndexOutOfBoundsException();
		}
		Node<T> current = last.next;
		Node<T> removedNode;
			//go to node before removed node
		for(int i=0; i<index-1; i++){
			current = current.next;
		}
		removedNode = current.next;
		current.next = removedNode.next;
		size--;
		
		return removedNode.value;
	}
	
	public T remove(T o){
		//removes a value when first found in the list
		int index = indexOf(o);
		if(index == -1){
			return null;
		}
		else{
			return remove(index);
		}
	}
	
	public T set(int index, T o){
		//replaces the value at the specified index with the specified value
		if(index>=size || index<0){
			throw new IndexOutOfBoundsException();
		}
		Node<T> current = last.next;
		for(int i=0; i<index; i++){
			current = current.next;
		}
		current.value = o;
		return current.value;
		
	}
	
	private class Iterator<T> implements java.util.Iterator<T>{
		private int index;
		
		public Iterator(){
			index = 0;
		}
		
		@Override
		public boolean hasNext(){
			return index < size;
		}
		
		@Override
		public T next(){
			return  (T) last.next;
		}
		
		@Override
		public void remove(){
			throw new UnsupportedOperationException();
		}
		
	}
}
