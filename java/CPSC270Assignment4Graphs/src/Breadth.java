//Kyle Myren 50%, Tyler Anderton 50%

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Breadth {
	public static <T> T[] getList(Vertex<T> vertex) {
		// This method receives a vertex in a undirected graph and
		// returns an array with the values in vertices
		// as they are found in breadth-first order

		// check if empty.
		List<Vertex<T>> visited = new ArrayList<>();
		List<T> values = new ArrayList<>();
		if (vertex == null) {
			return (T[]) values.toArray();
		}

		// go to first node
		// queue all edges
		// mark as visited and add to list
		// take next entry in queue and repeat
		// if taken entry already in visited list, move to next in queue
		// loop till queue empty then return list

		Vertex<T> myVertex = vertex;

		Queue<Vertex<T>> edgesToVisit = new LinkedList<>();

		// distance
		int distance = 0;

		edgesToVisit.offer(myVertex);

		while (!edgesToVisit.isEmpty()) {

			// pull from queue
			myVertex = edgesToVisit.remove();
			// if vertex not visited go about adding this vertex's values
			if (!visited.contains(myVertex)) {
				// add to visited current node
				visited.add(myVertex);
				// add edges to queue
				for (Vertex<T> neighbor : myVertex) {
					edgesToVisit.add(neighbor);
				}
			}
			// toss value away if node already visited
		}
		// construct an array from visited list that can be returned
		for (Vertex<T> v : visited) {
			values.add(v.getValue());
		}
		return (T[]) values.toArray();

	}

}
