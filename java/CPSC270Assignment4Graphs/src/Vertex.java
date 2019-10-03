import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vertex<T> implements Iterable<Vertex<T>> {
	private T              value;
	private List<Vertex<T>> neighbors;
	private Vertex<T>	parent;
	
	public Vertex(T value) {
		this.value     = value;
		this.neighbors = new ArrayList<>();
		this.parent = null;
	}
	public T getValue() {
		return value;
	}
	public Vertex<T> add(Vertex<T> neighbor) {
		if (neighbors.contains( neighbor )) {
			throw new IllegalArgumentException( "already a neighbor" );
		}
		neighbors.add( neighbor );
		return this;
	}
	
	public void setParent(Vertex<T> aVert){
		this.parent = aVert;
	}
	public Vertex<T> getParent(){
		return this.parent;
	}
	
	@Override
	public Iterator<Vertex<T>> iterator() {
		return neighbors.iterator();
	}
	@Override
	public String toString() {
		StringBuilder str   = new StringBuilder().append( value ).append("[");
		boolean       first = true;
		for (Vertex<T> n : neighbors) {
			str.append( first ? "" : "," ).append( n.value );
			first = false;
		}
		return str.append("]").toString();
	}
}