/**
 * After running the program over 100 times with 100 instances of 100 values,
 * first fit was more efficient 100% of the time. The ratio is usually 5:2 in 
 * favor of first fit, but seems to also range from 4:3 to even 6:2 in favor
 * of first fit. There are also between 10-25 ties for every 100 instances, but
 * that is not statistically significant enough to say that worst fit is 
 * just as good as first fit.
 * 
 * Want to see results for yourself? Try running the program! An outlier actually 
 * occurred where the number of Worst fit wins and ties were greater than first fit. 
 * 
 * 
 * William Touch
 * 
 */

import java.util.*;
import java.lang.Object.*;
import java.lang.Math.*;

public class BinPack {
	public static int sortedFirstFit(int[] itemSizes) {
		int[] used = new int[9999];
		for (int i = 0; i < itemSizes.length; i++) {
			used[i] = 0;
		}
		int binsUsed = 0;

		Arrays.sort(itemSizes);
		// System.out.println(itemSizes.length);
		int binLoc = 1;
		for (int item = 0; item < itemSizes.length; item++) {
			// System.out.println("IN FOR");
			// System.out.println(used[binLoc]);
			// System.out.println(itemSizes[item]);
			int measureItem = used[binLoc] + itemSizes[item];
			// System.out.println("MeasureItem: " + measureItem);
			while (measureItem > 10) {
				binLoc++;
				measureItem -= 10;
				// System.out.println("NEW BIN");
			}

			used[binLoc] = used[binLoc] + itemSizes[item];
			// System.out.println("BIN: " + used[binLoc]);

			binsUsed = Math.max(binsUsed, binLoc);

		}
		// System.out.println("Bins used: " + binsUsed);
		return binsUsed;
	}

	public static int worstFit(int[] itemSizes) {

		int[] used = new int[100];
		for (int i = 0; i < itemSizes.length; i++) {
			used[i] = 0;
		}
		int binsUsed = 0;

		int binLoc = 1;
		for (int item = 0; item < itemSizes.length; item++) {

			// Find the bin with the largest amount of space here
			int maxSpaceIndex = 0;
			;
			int maxSpaceVal = 0;
			// System.out.println("binsUsed: " + binsUsed);
			for (int i = 1; i <= binsUsed; i++) {
				// System.out.println("IN IF");
				int space = 10 - used[i];
				for (int j = 1; j <= binsUsed; j++) {
					int spaceCmp = 10 - used[j];
					if (space > spaceCmp) {
						maxSpaceIndex = i;
						maxSpaceVal = space;
					}/*
					 * else{ maxSpaceIndex = j; maxSpaceVal = spaceCmp; }
					 */
				}
			}

			// System.out.println(maxSpaceVal);
			// System.out.println(maxSpaceIndex);

			if (maxSpaceVal >= itemSizes[item]) {
				// System.out.println("MAXSPACEVAL: " + maxSpaceVal);
				// System.out.println("CHANGING BIN");
				binLoc = maxSpaceIndex;
			}

			int measureItem = used[binLoc] + itemSizes[item];

			// System.out.println("SPACE BIN: " + measureItem);

			while (measureItem > 10) {
				if (binLoc < binsUsed) {
					binLoc = binsUsed + 1;
				} else {
					binLoc++;
				}
				measureItem -= 10;
				// System.out.println("NEW BIN");
			}

			// System.out.println("BIN NUMBER: " + binLoc + "\n");

			used[binLoc] = used[binLoc] + itemSizes[item];
			// System.out.println("BIN: " + used[binLoc] + "\n");

			binsUsed = Math.max(binsUsed, binLoc);

		}
		// System.out.println("Bins used: " + binsUsed);
		return binsUsed;
	}

	
	//WorstFit
		//put next item in (nonempty) bin that leaves the most empty space
		//use new bin only when no other choice
	//BestFit
		//put next item in bin that leaves the least empty space
		//use new bin only when no other choice
	public static void main(String[] args) {

		int FirstWins = 0;
		int WorstWins = 0;
		int ties = 0;

		for (int j = 0; j <= 100; j++) {
			int[] arr = new int[100];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (int) (Math.random() * 10 + 1);
				 System.out.println(arr[i]);
			}
			// System.out.println("\n");
			int[] arr2 = new int[100];
			for (int i = 0; i < arr.length; i++) {
				arr2[i] = arr[i];
				// System.out.println(arr[i]);
			}

			if (sortedFirstFit(arr) < worstFit(arr2)) {
				FirstWins++;
			} else if (worstFit(arr2) < sortedFirstFit(arr)) {
				WorstWins++;
			} else {
				ties++;
			}
		}

		System.out.println("First Wins: " + FirstWins);
		System.out.println("Worst Wins: " + WorstWins);
		System.out.println("Ties: " + ties);

	}

}
