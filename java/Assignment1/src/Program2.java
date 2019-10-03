//	Kyle	100%, Michael 100%, both completed independently before contacting each other.

public class Program2 {
	public	static	int	getMostRepeatedNumber(int[][] array)
	{
		if(array.length==0)
		{
			return -1;
		}
		
		//array that will keep count of usage
		int[] count = new int[10];
		
		for(int i=0; i<array.length; i++)
		{
			for(int g=0; g<array[i].length; g++)
			{
				count[array[i][g]]++;
			}
		}
		
		int mostTimesRepeated=0;
		for(int i = 0; i<count.length; i++)
		{
			if(count[i] >= mostTimesRepeated)
			{
				mostTimesRepeated = count[i];
			}			
		}
		
		for(int i = 0; i<count.length; i++)
		{
			if(count[i]==mostTimesRepeated)
			{
				return i;
			}
		}
		
		//if this number is returned something is wrong
		return 9999; 
		
	}
}
