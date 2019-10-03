import java.util.Arrays;

public class Lab03One {
	public static Double getMedian( Integer[] array )
	{
		//order the array
		Arrays.sort(array); 
		Double result = 0.0;
		Double midSums = 0.0;
		if(array.length==0)
		{
			return result = 0.0;
		}
		
		if(array.length%2==0)
		{
			//array is even length and the 2 medians get averaged
			midSums = (double) (array[array.length/2] + array[array.length/2 - 1]);
			result = midSums/2;
			return result;
		}
		else
		{
			result = (double)(array[array.length/2]);
			return result;
		}	
		
		
	}
	
	public static Character[] getDigits( Character[] array )
	{
		int totalDigits = 0;
		int currentDigit = 0;
		for(int i =0; i<array.length; i++)
		{
			if((array[i]== '0') || (array[i]== '1') || (array[i]== '2') || (array[i]== '3') || (array[i]== '4') 
					|| (array[i]== '5') || (array[i]== '6') || (array[i]== '7') || (array[i]== '8') || (array[i]== '9'))
			{
				totalDigits = totalDigits + 1;
			}
		}
		
		Character[] onlyDigits = new Character[totalDigits];
		
		for(int i =0; i<array.length; i++)
		{
			if((array[i]== '0') || (array[i]== '1') || (array[i]== '2') || (array[i]== '3') || (array[i]== '4') 
					|| (array[i]== '5') || (array[i]== '6') || (array[i]== '7') || (array[i]== '8') || (array[i]== '9'))
			{
				onlyDigits[currentDigit] = array[i];
				currentDigit++;
			}
		}
		
		
		return onlyDigits;
	}
	
}
