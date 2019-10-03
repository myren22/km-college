import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BlackOps {
	public static int minimumRoads(int[][] roads, int insertion, int extraction) {
		
		ArrayList<Integer> combinedRoutes  = new ArrayList<Integer>();
		ArrayList<Integer> anyRoute = new ArrayList<Integer>();
		ArrayList<Integer> anyRoute2 = new ArrayList<Integer>();

		int numPaths = 0;
		int [] routeFromBeginning = matrixBreadthFinder(roads, insertion);
		int [] routeFromEnd = matrixBreadthFinder(roads, extraction);
		for(int i = 0; i < routeFromBeginning.length; i++){
			anyRoute.add(routeFromEnd[i]);
			anyRoute2.add(routeFromBeginning[i]);
		}
		
		for(int i = 0; i < routeFromBeginning.length; i++){
			int values1 =  routeFromBeginning[i];
			int values2 = routeFromEnd[i];
			int sum = values1 + values2;
			combinedRoutes.add(sum);
		}
		
		for(int i = 0; i < combinedRoutes.size(); i++){
			if(combinedRoutes.get(i) > numPaths){
				numPaths = combinedRoutes.get(i);
	}
}
		

		return numPaths;
	}
	public static int [] matrixBreadthFinder(int [][] roads, int insertion){
		ArrayList<Integer> nodeList = new ArrayList<Integer>();

		int numofNodes = 0;
		for (int i = 0; i < roads.length; i++) {
			for (int j = 0; j < roads[i].length; j++) {
				if (!(nodeList.equals(roads[i][j]))) {
					nodeList.add(roads[i][j]);
				}
				
			}
		}
		numofNodes = nodeList.size();
	
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(insertion);
		
		
		int[] visited = new int[numofNodes];
		
		int[] pathDistance = new int[numofNodes];
		final int undiscovered = 0;
		final int discovered = 1;
		final int finished = -1;
		pathDistance[nodeList.indexOf(insertion)] = 0;
		visited[nodeList.indexOf(insertion)] = discovered;
		
		while (!(queue.isEmpty())) {
			int currNode = queue.remove();
			int nextNode = -2;
			

			for (int i = 0; i < roads.length; i++) {
				for (int j = 0; j < roads[i].length; j++) {

					if (currNode == roads[i][j]) {
						if (j == 0) {
							nextNode = roads[i][j + 1];
						} else {
							nextNode = roads[i][j - 1];
						}
						if (visited[nodeList.indexOf(nextNode)] == undiscovered) {
							
							pathDistance[nodeList.indexOf(nextNode)] = pathDistance[nodeList.indexOf(currNode)] + 1;
							visited[nodeList.indexOf(nextNode)] = discovered; 
							queue.offer(nextNode);
			
						}
					}
					
				}

			}
			visited[nodeList.indexOf(currNode)] = finished;
		}
		
		return pathDistance;
	}


}
