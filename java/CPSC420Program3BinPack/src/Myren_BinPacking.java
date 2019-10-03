//Kyle Myren
//best fit wins around 89% of the time, Worst fit 4%, Ties 6%
//each value deviates around 5%, but not much more than that

public class Myren_BinPacking {

	//WorstFit
		//put next item in (nonempty) bin that leaves the most empty space
		//use new bin only when no other choice
	public static int worstFit(int[] listOfSizes) {	
		int[] binsUsed = new int[100];
		int binLoc=0;
		
		for(int item=0; item<listOfSizes.length; item++){
			//find emptiest bin
			int mostSpace=0; 
			int mostSpaceBin=-1;
			//iterate through partially filled bins
			for(int currentBin=0; currentBin<binLoc; currentBin++){
				if(mostSpace< binsUsed[currentBin] && binsUsed[currentBin] > listOfSizes[item]){
					mostSpace = binsUsed[currentBin];
					mostSpaceBin = currentBin;
//					System.out.println("setting worstFit bins");
				}
			}
			if(mostSpaceBin==-1){
				binsUsed[binLoc] = 10 - listOfSizes[item];
				binLoc++;
			}
			else{
				binsUsed[mostSpaceBin] = binsUsed[mostSpaceBin] - listOfSizes[item];
			}
		}	
		return binLoc;
	}
	
	//BestFit
		//put next item in bin that leaves the least empty space
		//use new bin only when no other choice
	public static int bestFit(int[] listOfSizes) {	
		int[] binsUsed = new int[100];
		int binLoc=0;
		
		for(int item=0; item<listOfSizes.length; item++){
			//find most filled bin
			int leastSpace=10; 
			int leastSpaceBin=20;
			//iterate through partially filled bins
			for(int currentBin=0; currentBin<binLoc; currentBin++){
				if(leastSpace > binsUsed[currentBin] && binsUsed[currentBin] > listOfSizes[item]){
					leastSpace = binsUsed[currentBin];
					leastSpaceBin = currentBin;
//					System.out.println("setting bestFit bins");
				}
			}
			if(leastSpaceBin==20){
				binsUsed[binLoc] = 10 - listOfSizes[item];
				binLoc++;
			}
			else{
				binsUsed[leastSpaceBin] = binsUsed[leastSpaceBin] - listOfSizes[item];
			}
		}	
		return binLoc;
	}
	
	public static void main(String[] args) {
		//bin max size 10
		int maxBinSize = 10;
		//array size 100 holding sizes
		int[] listOfSizes = new int[100];
		
		int bestFitWins=0;
		int worstFitWins=0;
		int ties=0;
		
		//100 instances, or just set to 10000
		for(int instance=0; instance<=1000; instance++){
			//instantiate listOfSizes with 100 random sizes
			for(int i=0; i<listOfSizes.length; i++){
				listOfSizes[i]= (int) (Math.random() * maxBinSize + 1); //gives #s 1-10
			}
			
			//check quality of each method
			int worstBinsUsed = worstFit(listOfSizes);
//			System.out.println("Worstfit Bins used:"+worstBinsUsed);
			int bestBinsUsed = bestFit(listOfSizes);
//			System.out.println("Bestfit Bins used:"+bestBinsUsed);
			if(worstBinsUsed > bestBinsUsed){
				bestFitWins++;
			} else if(worstBinsUsed < bestBinsUsed){
				worstFitWins++;
			}else{
				ties++;
			}
		}
		
		System.out.println("BestFit Won: " + bestFitWins);
		System.out.println("WorstFit Won: " + worstFitWins);
		System.out.println("Ties: " + ties);
	}
	
	

}
