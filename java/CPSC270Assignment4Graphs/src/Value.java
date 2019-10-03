//Kyle Myren 50%, Tyler Anderton 50%

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Value {
	public static <T extends Comparable<? super T>> int getDifference(
			Vertex<T> vertex) {
		// recieves a vertex in an undirected graph and returns the positive
		// difference between
		// the minimum and maximum value in the graph. Thrown an
		// IllegalArgumentException if the graph has no vertices

		// check if has any values
		if (vertex == null) {
			throw new IllegalArgumentException();
		}

		List<Vertex<T>> visited = new ArrayList<>();
		List<T> values = new ArrayList<>();
		Vertex<T> myVertex = vertex;
		Queue<Vertex<T>> edgesToVisit = new LinkedList<>();
		// cycle through and get list of values.
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
		for (Vertex<T> v : visited) {
			System.out.print(v.getValue());
			values.add(v.getValue());
		}

		T min = values.get(0);
		T max = values.get(0);

		for (int i = 0; i < values.size(); i++) {
			if (i == 0) {
				min = values.get(0);
				max = values.get(0);
			}
			if (min.compareTo(values.get(i)) > 0) {
				min = values.get(i);
			}
			if (max.compareTo(values.get(i)) < 0) {
				max = values.get(i);
			}
		}
		System.out.print("   ");
		System.out.print(min);
		System.out.print(max);
		Integer difference = max.compareTo(min);
		return difference;

		// find difference
		// return difference
	}
}
