package poop;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedLast<T> {

	private Node<T> head;
    Node<T>current = head;
    Node<T> temp;
    int size;
    int pos = 0;
    
	
	public LinkedLast() {

		this.head = new Node<T>(null, null);
		size = 0;
		current = head;

	}
	public void clear(){
		head = null;
		size = 0;
	}

	public void add(T o) {
		temp = current.next;
		current.next = new Node<T>(o, head); 
		current = current.next;
		size++;
		pos++;
	}
	public void add(int index, T o){
		this.goFirst();
		for(int i = 1; i<index; i++){
			this.goNext();
		}
		temp = current.next;
		current.next = new Node<T>(o, head); 
		current = current.next;
		current.next = temp;
		size++;
		pos++;
	}
	public T set(int index, T o){
		T val;
		this.goFirst();
		for(int i = 1; i<=index; i++){
		this.goNext();
		}
		val = current.val;
		current.val = o;
		return val;
		
	}
	
	public Iterator<T> iterator(){
		return this.iterator();
	}
	public boolean hasNext(){
		
		return size>=1;
		}
	public void goNext() {
		if(hasNext() == false){
			throw new NoSuchElementException();
		}
		else{
			current = current.next;
			pos++;
		}
	}
	public void remove(){
		throw new UnsupportedOperationException();
	}
	
	
	public T get(int index) {
		
		this.goFirst();
		if(this.hasNext()==false && this.getSize() == 0){
			throw new IllegalArgumentException();
		}
		for(int i = 1; i<=index; i++){
			this.goNext();
		}
		T val = current.val;
		return val;

	}

	public T remove(T obj) {
		this.goFirst();
		T t = null;
		for(int i = 1; i<=this.getSize(); i++){
			if(this.get(i)== obj){
				 t = current.val;
				current.val= current.next.val;
				current.next = current.next.next;
				size--;
				for(int j = i+3; j<= this.getSize(); j++){
					current.val= current.next.val;
					current.next = current.next.next;
				}
			}
			this.goNext();
		}
		return t;
		
	}
	public T remove(int index){
		this.goFirst();
		T t = null;
		for(int i = 1; i<=index; i++){
			this.goNext();
		}
		t= current.val;
		current.val= current.next.val;
		current.next = current.next.next;
		for(int i = index+3; i<= this.getSize(); i++){
			current.val= current.next.val;
			current.next = current.next.next;
		}
		size--;
		return t;
		
		
	}
	public boolean contains(T o){
		this.goFirst();
		boolean b= false;
		for(int i = 1; i<=this.getSize(); i++){
			if(this.get(i)== o){
				b= true;
			}
			this.goNext();}
		
		return b;
	}

	public int indexOf(T obj) {
		this.goFirst();
		int r= -1;
		for(int i = 1; i<=this.getSize(); i++){
			if(this.get(i)== obj){
				r = i;
			}
			this.goNext();
		}
		if((r < 0)||(r > size)){
			throw new ArrayIndexOutOfBoundsException();
		}
		return r;
	}
	@Override
	public boolean equals(java.lang.Object obj) {
		boolean b = true;
		if (obj instanceof LinkedLast) {
			LinkedLast<T> test = ((LinkedLast<T>) obj);
			if (test.getSize() != this.getSize()) {
				b= false;
			}
			if(b == true){
				for(int i = 1; i <= this.getSize(); i++){
					if(test.get(i) != this.get(i)){
						b= false;
						}	
					}
				}
			
		}
		return b;

	}

	public void goFirst() {
		current = head;
		pos = 1;
	}


	public boolean isEmpty() {
		return head.next == null;
	}

	public int position() {
		if (head.next == null) {
			pos = -1;
			return pos;
		}

		return pos;
	}

	public int getSize() {
		return size;
	}
	
	private class Iterator<T> implements java.util.Iterator<T>{
		
		public Iterator(){
			
		}
		
		@Override
		public boolean hasNext(){
			
		}
		
		@Override
		public T next(){
			LinkedLast.add(current);
		}
		
		@Override
		public void remove(){
			
		}
		
	}
}
