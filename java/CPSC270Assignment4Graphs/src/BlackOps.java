//Kyle Myren 50%, Tyler Anderton50%

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BlackOps {

	public static int[] matrixBreadthFinder(int[][] roads, int insertion) {
		// same idea as getList but reworked to use a 2d matrix of values
		// and searching for the greatest distance direct distance.
		
		ArrayList<Integer> nodeList = new ArrayList<Integer>();

		for (int i = 0; i < roads.length; i++) {
			for (int j = 0; j < roads[i].length; j++) {
				if (!(nodeList.equals(roads[i][j]))) {
					nodeList.add(roads[i][j]);
				}

			}
		}
		int numofNodes = nodeList.size();

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(insertion);

		int[] visited = new int[numofNodes];
		int[] pathDistance = new int[numofNodes];

		// set the array elements
		pathDistance[nodeList.indexOf(insertion)] = 0;
		visited[nodeList.indexOf(insertion)] = 1;

		while (!(queue.isEmpty())) {
			int currentNode = queue.remove();
			int nextNode = -2;
			
			//cycle through the rows and columns
			for (int i = 0; i < roads.length; i++) {
				for (int j = 0; j < roads[i].length; j++) {

					if (currentNode == roads[i][j]) {
						if (j == 0) {
							nextNode = roads[i][j + 1];
						} else {
							nextNode = roads[i][j - 1];
						}
						if (visited[nodeList.indexOf(nextNode)] == 0) {

							pathDistance[nodeList.indexOf(nextNode)] = pathDistance[nodeList
									.indexOf(currentNode)] + 1;
							visited[nodeList.indexOf(nextNode)] = 1;
							queue.offer(nextNode);

						}
					}
				}
			}
			visited[nodeList.indexOf(currentNode)] = -1;
		}

		return pathDistance;
	}

	public static int minimumRoads(int[][] roads, int insertion, int extraction) {
		// The method receives “roads” (a 2-column 2-dimensional array of
		// integers), and integers “insertion” and “extraction”.
		// Each row in “roads” indicates a road connecting 2 buildings
		// (which as implied are identified by numbers).
		// Integers “insertion” and “extraction” indicate the initial and final
		// buildings in the raid.
		ArrayList<Integer> combinedRoutes = new ArrayList<Integer>();

		//the desired result is the longest TOTAL traversals from insertion to extraction
		int numPaths = 0;
		int[] routeFromBeginning = matrixBreadthFinder(roads, insertion);
		int[] routeFromEnd = matrixBreadthFinder(roads, extraction);

		for (int i = 0; i < routeFromBeginning.length; i++) {
			int values1 = routeFromBeginning[i];
			int values2 = routeFromEnd[i];
			int sum = values1 + values2;
			combinedRoutes.add(sum);
		}

		for (int i = 0; i < combinedRoutes.size(); i++) {
			if (combinedRoutes.get(i) > numPaths) {
				numPaths = combinedRoutes.get(i);
			}
		}

		return numPaths;
	}

}
