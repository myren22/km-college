//	Kyle	100%, Michael 100%, both completed independently before contacting each other.

public class Program1 {
	public static boolean allLess(int[] one, int[] two)
	{
		//first determine shortest array
		int smallestArrayLength;
		if(one.length>two.length)
		{
			smallestArrayLength= two.length;
		}
		else
		{
			smallestArrayLength= one.length;
		}
		
		//then check array until reaching a an element that is one>two[return false]
		//or reaches the end of smallest array[return true]
		for(int i = 0; i<smallestArrayLength; i++)
		{
			if(one[i]>=two[i])
			{
				return false;
			}
		}
		return true;	
	}
}
