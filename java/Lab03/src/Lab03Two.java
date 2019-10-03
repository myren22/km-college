import java.util.ArrayList;

public class Lab03Two {
	public static int getTally(ArrayList<Integer> list, int number)
	{
		int tally = 0;
		for(int i =0; i<list.size(); i++)
		{
			if(list.get(i) == number)
			{
				tally++;
			}
		}
		return tally;
	}
	
	public static int getFirstIndex(ArrayList<Integer> list, int number)
	{
		for(int i =0; i<list.size(); i++)
		{
			if(list.get(i) == number)
			{
				return i;
			}
		}
		//if passed through without finding
		return -1;
	}
	
	public static void doReverse(ArrayList<Integer> list)
	{
		
		int size = list.size();
		for(int i =0; i<list.size(); i++)
		{
			list.add(i, list.get(size-1));
			list.remove(size);			
		}	
//		ArrayList<Integer> placeholder = new ArrayList<Integer>();
//		for(int i=0; i<list.size(); i++)
//		{
//			placeholder.add(list.get(i));
//		}
//		
//		for(int i=0; i<list.size(); i++)
//		{
//			//for(int g=0; i<list.size(); g++)
//			for(int g=placeholder.size()-1; g>=0; g--)
//			{
//				list.set(i, placeholder.get(g));
//				
//			}
//		}		
	
	}
	
	public static ArrayList<Integer> getSorted(ArrayList<Integer> one, ArrayList<Integer> two, boolean ascendingly)
	{
		//check for ascending or descending
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(ascendingly == true)
		{
			//for ascending go 1,1,2,4,6,...
			for(int i =0; i<1200; i++)	//ideally: i=lowest number of both arrays; i=<maximum; 
			{
				for(int g = 0; g< getTally(one, i); g++)
				{
					result.add(i);
				}
				for(int g = 0; g< getTally(two, i); g++)
				{
					result.add(i);
				}
			}
			
		}
		else
		{
			//for descending go 10,7,4,4,3,...
			for(int i = 1200; i>=0; i--)	//ideally: i=maximum number of both arrays; i=<lowest; 
			{
				for(int g = 0; g< getTally(one, i); g++)
				{
					result.add(i);
				}
				for(int g = 0; g< getTally(two, i); g++)
				{
					result.add(i);
				}
			}			
		}
		return result;
		
	}
	
	public static ArrayList<Integer> getUnion( ArrayList<Integer> one, ArrayList<Integer> two )
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i = 0; i < one.size(); i++)
		{
			if(!result.contains(one.get(i)))
			{
				result.add(one.get(i));
			}			
		}
		for(int i = 0; i < two.size(); i++)
		{
			if(!result.contains(two.get(i)))
			{
				result.add(two.get(i));
			}	
		}
		return result;
	}
	
	public static ArrayList<Double> getIntersection( ArrayList<Double> one, ArrayList<Double> two )
	{
		ArrayList<Double> placeholder = new ArrayList<Double>();
		ArrayList<Double> result = new ArrayList<Double>();
		
		for(int i = 0; i < one.size(); i++)
		{
			if(!placeholder.contains(one.get(i)))
			{
				placeholder.add(one.get(i));
			}			
		}
		for(int i = 0; i < two.size(); i++)
		{
			if(!result.contains(two.get(i)))
			{				
				if(placeholder.contains(two.get(i)))
				{
					result.add(two.get(i));
				}	
			}
					
			
		}
		return result;
		
		
	}
	
	public static ArrayList<String> getDifference( ArrayList<String> one, ArrayList<String> two )
	{
		ArrayList<String> result = new ArrayList<String>();
		
		for(int i = 0; i < one.size(); i++)
		{			
			if(!two.contains(one.get(i)))
			{
				if(!result.contains(one.get(i)))
				{
					result.add(one.get(i));
				}
			}
		}
		
		for(int i = 0; i < two.size(); i++)
		{			
			if(!one.contains(two.get(i)))
			{
				if(!result.contains(two.get(i)))
				{
					result.add(two.get(i));
				}
			}
		}
		return result;
	}

	
}
