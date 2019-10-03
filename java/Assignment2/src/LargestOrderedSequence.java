//Kyle 100%. Never ended up contacting partner in project.

import java.util.ArrayList;


public class LargestOrderedSequence {
	
	
	public static int getLargestOrderedSequence(ArrayList<Integer> list)
	{
		int count;
		int cyclecount = 1;
		
		if(list.size()==0)
		{
			return 0;
		}
		else
		{
			count = 1;
		}
		for(int i=0; i<list.size()-1; i++)
		{
			if(list.get(i)<= list.get(i+1))
			{
				cyclecount++;
				if(cyclecount>count)
				{
					count = cyclecount;
				}
			}
			else
			{
				cyclecount = 1;
			}
		}	
		
		return count;
	}
}
