import java.util.ArrayList;


public class Lab03Three {
	public static int[] getLetters( ArrayList<String> list )
	{
		//Create an int array of size 26 to tally each letter
		int[] letterTally = new int[26];
		
		for(int i =0; i<list.size(); i++)
		{
			String str1 = list.get(i);
			for(int g=0; g<str1.length(); g++)
			{
				Character charCheck = str1.charAt(g);
				charCheck = Character.toUpperCase(charCheck);
				
				if(charCheck == 'A')	{
					letterTally[0]++;
				}
				else if(charCheck == 'B')	{
					letterTally[1]++;
				}
				else if(charCheck == 'C')	{
					letterTally[2]++;
				}
				else if(charCheck == 'D')	{
					letterTally[3]++;
				}
				else if(charCheck == 'E')	{
					letterTally[4]++;
				}
				else if(charCheck == 'F')	{
					letterTally[5]++;
				}
				else if(charCheck == 'G')	{
					letterTally[6]++;
				}
				else if(charCheck == 'H')	{
					letterTally[7]++;
				}
				else if(charCheck == 'I')	{
					letterTally[8]++;
				}
				else if(charCheck == 'J')	{
					letterTally[9]++;
				}
				else if(charCheck == 'K')	{
					letterTally[10]++;
				}
				else if(charCheck == 'L')	{
					letterTally[11]++;
				}
				else if(charCheck == 'M')	{
					letterTally[12]++;
				}
				else if(charCheck == 'N')	{
					letterTally[13]++;
				}
				else if(charCheck == 'O')	{
					letterTally[14]++;
				}
				else if(charCheck == 'P')	{
					letterTally[15]++;
				}
				else if(charCheck == 'Q')	{
					letterTally[16]++;
				}
				else if(charCheck == 'R')	{
					letterTally[17]++;
				}
				else if(charCheck == 'S')	{
					letterTally[18]++;
				}
				else if(charCheck == 'T')	{
					letterTally[19]++;
				}
				else if(charCheck == 'U')	{
					letterTally[20]++;
				}
				else if(charCheck == 'V')	{
					letterTally[21]++;
				}
				else if(charCheck == 'W')	{
					letterTally[22]++;
				}
				else if(charCheck == 'X')	{
					letterTally[23]++;
				}
				else if(charCheck == 'Y')	{
					letterTally[24]++;
				}
				else if(charCheck == 'Z')	{
					letterTally[25]++;
				}
			}
		
		}
		return letterTally;
	}
}
