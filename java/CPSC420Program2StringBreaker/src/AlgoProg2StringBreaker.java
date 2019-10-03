//Kyle Myren
//Algorithms Program 2 - String Breaker

//could remove a lot of comments/testing code to make it cleaner, but eh it will help if I ever come back to this
//program runs super quick and there are no hiccups
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class AlgoProg2StringBreaker {
	static int numBreakPoints;
	static int stringlength;
	static int[] breakpointArray;
	static ArrayList<Integer> minseq = new ArrayList<Integer>();
	static ArrayList<Integer> visited = new ArrayList<Integer>();
	static ArrayList<Integer> notVisited = new ArrayList<Integer>();
	static ArrayList<Integer> allBreaks = new ArrayList<Integer>();
	static int numCuts=0;
	static int leftCounter=0;
	static int rightCounter=0;
	static int iterationCounter=0;

	public static void main(String[] args) throws IOException {
		// file io stuff
		File file = new File("Breakpoint1704.txt");	//change input file here
		try {
			Scanner scanner = new Scanner(file);
			// String Size
			String line = scanner.next();
			stringlength = Integer.parseInt(line);
			// Number of breakpoints
			line = scanner.next();
			numBreakPoints = Integer.parseInt(line);
			breakpointArray = new int[numBreakPoints];
			int z = 0;
			while (scanner.hasNext()) {
				// 0...num breakpoints
				breakpointArray[z] = Integer.parseInt(scanner.next());
				z++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		// --------main routine for starting to make sense of everything ----------
		int midCut = getClosestK(breakpointArray, stringlength/2);
		for (int i = 0; i < breakpointArray.length; i++) {
			allBreaks.add(breakpointArray[i]);
		}
		int costOfCheapestPath = stringCut(breakpointArray,0,stringlength, midCut);	
		//The returned sequence is in minseq
		
		System.out.println("numbreakpoints: " + numBreakPoints);			
		System.out.println("returned Cost: " + costOfCheapestPath);
		System.out.println("numCuts global var: " + numCuts); //should equal the numberBreakpoints
		
		//see what sequence I got
		for (int i = 0; i < minseq.size(); i++) {
//			System.out.println(""+ minseq.get(i));
		}
		
		//for testing if any nodes missed from final minseq
		for (int i = 0; i < breakpointArray.length; i++) {
			if(minseq.contains(breakpointArray[i])){
				visited.add(breakpointArray[i]);
			}
			else{
				notVisited.add(breakpointArray[i]);
			}
		}
		System.out.println("total visited: " + visited.size());
		System.out.println("total notVisited: " + notVisited.size());
		iterationCounter +=rightCounter+leftCounter;
		System.out.println("iteration counter" + iterationCounter);
		
	}

	public static int stringCut(int[] subArray,int leftedge, int rightedge, int indexCut) {
		numCuts++;
		int cost = rightedge-leftedge;
		minseq.add(subArray[indexCut]);
		
		
//		System.out.println("Cut "+numCuts+ " - Value :" + subArray[indexCut]);
		//basecase, when only 1 breakpoint in set, just split in half
		if(subArray.length == 1){
			return cost;
		}	
		
		//check left side and cut. should stop cutting on the left side if no breakpoints left of indexcut
		//will find centermost breakpoint then cut in half
		if(indexCut>0){
//			System.out.println("Left Loopindexcut:" + indexCut);
			leftCounter++;
			int[] leftArray = Arrays.copyOfRange(subArray, 0, indexCut);//javadocs say nothing on cost of running this method
//			System.out.println("Left arraysize:" + leftArray.length);
			
			int idealCut= (subArray[indexCut]-leftedge)/2;
			int leftCut= getClosestK(leftArray, idealCut);
//			System.out.println("Left cut " +leftCounter + " is: " + leftArray[leftCut]);
//			System.out.println("subArray[indexCut]="+subArray[indexCut]+"  leftedge="+leftedge+"  idealcut="+idealCut);
			
			cost+= stringCut(leftArray,leftedge, subArray[indexCut], leftCut);
		}
//		System.out.println("indexCut "  + " is: " + indexCut);
//		System.out.println("subArray.length "  + " is: " + subArray.length);
//		//check right side and cut
//		for (int i = 0; i < subArray.length; i++) {
//			System.out.println("Sub Array Contents: "+subArray[i]);
//		}
		
		
		//check right side and cut. should stop cutting on the left side if no breakpoints left of indexcut
		if(subArray.length-1> indexCut){
			rightCounter++;
//			System.out.println("Inside the right side loop" +indexCut);
//			System.out.println("indexcut:" + indexCut);
			
			int[] rightArray = Arrays.copyOfRange(subArray, indexCut+1, subArray.length);
			int idealCut = (rightedge-subArray[indexCut])/2 + subArray[indexCut];
			int rightCut = getClosestK(rightArray, idealCut);
			
//			System.out.println("Right arraysize:" + rightArray.length);			
//			System.out.println("Right cut " +rightCounter + " is: " + rightArray[rightCut]);
//			System.out.println("rightCut: "+ rightCut);
//			for (int i = 0; i < rightArray.length; i++) {
//				System.out.println("Right Array Contents: "+rightArray[i]);
//			}
			
			cost+= stringCut(rightArray, subArray[indexCut], rightedge, rightCut);
		}
		
		return cost;
		
		

	}
	
	//this method is logn, its essentially binary search
	public static int getClosestK(int[] a, int x) {

	    int low = 0;
	    int high = a.length - 1;

	    if (high < 0)
	        throw new IllegalArgumentException("The array cannot be empty");
	    
	    while (low < high) {
	        int mid = (low + high) / 2;
	        assert(mid < high);
	        int d1 = Math.abs(a[mid  ] - x);
	        int d2 = Math.abs(a[mid+1] - x);
	        iterationCounter++;
	        if (d2 <= d1) //x is closer to d2, its on right half of array
	        {
	            low = mid+1; //set lower bound to mid
	        }
	        else	//x is on left side of array
	        {
	            high = mid; //set upper bound to mid
	        }
	    }
	    return high;//currently set to return index of closest node
	}

}




