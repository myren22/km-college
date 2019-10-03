//Kyle Myren 50%, Tyler Anderton 50%

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Path {
	public static Integer[] getShortest(Vertex<Integer> vertex) {
		// receives a vertex in an undirected graph of integers and returns the
		// shortest path(in number of edges), between min and max values
		// If several paths were the shortest, return the one whose sum of
		// values is less.
		// Values must be in the order they are traversed going from vertex with
		// the minimum value to vertex with maximum value.
		// throw and illegalarg exception if graph has no vertices.

		if (vertex == null) {
			throw new IllegalArgumentException();
		}

		List<Vertex<Integer>> visitedList = new ArrayList<>();
		List<Integer> values = new ArrayList<>();
		Vertex<Integer> myVertex = vertex;
		Queue<Vertex<Integer>> edgesToVisit = new LinkedList<>();
		// cycle through and get list of values.
		edgesToVisit.offer(myVertex);
		while (!edgesToVisit.isEmpty()) {
			// pull from queue
			myVertex = edgesToVisit.remove();
			// if vertex not visited go about adding this vertex's values
			if (!visitedList.contains(myVertex)) {
				// add to visited current node

				visitedList.add(myVertex);
				// add edges to queue
				for (Vertex<Integer> neighbor : myVertex) {
					edgesToVisit.add(neighbor);
				}
			}
			// toss value away if node already visited
		}
		for (Vertex<Integer> v : visitedList) {
			values.add((Integer) v.getValue());
		}

		Integer min = values.get(0);
		Integer max = values.get(0);
		Vertex<Integer> minVertex = myVertex;
		Vertex<Integer> maxVertex = myVertex;

		int count = 0;
		for (Vertex<Integer> v : visitedList) {

			if (count == 0) {
				min = values.get(0);
				max = values.get(0);
				minVertex = v;
				maxVertex = v;
			}
			if (min.compareTo(values.get(count)) > 0) {
				min = values.get(count);
				minVertex = v;
			}
			if (max.compareTo(values.get(count)) < 0) {
				max = values.get(count);
				maxVertex = v;
			}
			count++;
		}
		count = 0;
		List<Vertex<Integer>> minimumList = new ArrayList();
		for (Vertex<Integer> v : visitedList) {
			// check if multiple minimums
			System.out.println("values.get" + values.get(count));
			if (min.compareTo(values.get(count)) == 0) {
				minimumList.add(v);
			}
			count++;
		}
		List<Vertex<Integer>> result = new ArrayList<>();
		List<Vertex<Integer>> result2 = new ArrayList<>();
		int smallestList = 100;
		for (int i = 0; i < minimumList.size(); i++) {
			result2 = search(minimumList.get(i), maxVertex);
			int x = sumList(result2);
			System.out.println("sumlist: " + x);
			if (x < smallestList) {
				smallestList = x;
				System.out.println("current min: " + smallestList);
				minVertex = minimumList.get(i);
			}
		}
		result = search(minVertex, maxVertex);
		Integer[] please = new Integer[result.size()];
		System.out.println("Search Results:");
		int g = 0;
		for (Vertex<Integer> v : result) {

			values.add(v.getValue());
			please[g] = v.getValue();
			System.out.println(v.getValue());
			g++;
		}
		System.out.println("please Results:");

		for (int i = 0; i < please.length; i++) {
			System.out.println(please[i]);
		}

		return please;

	}

	protected static List constructPath(Vertex<Integer> node) {
		LinkedList path = new LinkedList();
		while (node.getParent() != null) {
			path.addFirst(node);
			node = node.getParent();
		}
		path.add(0, node);

		return path;
	}

	public static List<Vertex<Integer>> search(Vertex<Integer> startNode,
			Vertex<Integer> goalNode) {
		// list of visited nodes
		LinkedList closedList = new LinkedList();

		// list of nodes to visit (sorted)
		LinkedList openList = new LinkedList();
		openList.add(startNode);
		startNode.setParent(null);

		while (!openList.isEmpty()) {
			Vertex<Integer> myVertex = (Vertex<Integer>) openList.removeFirst();
			if (myVertex == goalNode) {
				// path found!
				List<Vertex<Integer>> derp = constructPath(goalNode);
				Integer[] result = new Integer[derp.size()];
				return derp;
			} else {
				closedList.add(myVertex);
				// add neighbors to the open list
				// Iterator i = node.neighbors.iterator();
				for (Vertex<Integer> vert : myVertex) {
					// node= vert;
					if (!closedList.contains(vert) && !openList.contains(vert)) {
						vert.setParent(myVertex);
						openList.add(vert);
					}
				}
			}
		}

		// no path found
		return null;
	}

	public static int sumList(List<Vertex<Integer>> listToSum) {
		int g = 0;
		for (Vertex<Integer> v : listToSum) {
			g += v.getValue();
		}
		return g;
	}
}
