//	Kyle	100%, Michael 100%, both completed independently before contacting each other.

public class Program3 {
	public	static	boolean isAmazingArray(int[][]	array)
	{
		//establish the sum that all horizontals and verticals must equal
		int uniqueSum = 0;
		for(int i = 0; i<array.length; i++)
		{
			uniqueSum = uniqueSum + array[i][0];
		}
		
		
		for(int i = 0; i<array.length; i++)
		{
			//check rows 
			int rowSum =0;
			for(int g = 0; g<array.length; g++)
			{
				rowSum = rowSum + array[i][g];
			}
			if(rowSum != uniqueSum)
			{
				return false;
			}			
		}
		
		for(int i = 0; i<array[0].length; i++)
		{
			//check columns 
			int colSum =0;
			for(int g = 0; g<array.length; g++)
			{
				colSum += array[g][i];
			}
			if(colSum != uniqueSum)
			{
				return false;
			}			
		}
		
		
		
		
		return true;
	}
}
