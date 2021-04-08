import java.util.*;

public class ImplementStr 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("haystack = ");
		String haystack = keyboard.nextLine();
		System.out.print("needle = ");
		String needle = keyboard.nextLine();
		
		int index = findIndex(haystack, needle);
		System.out.println(index);
	}
	
	public static int findIndex(String str1, String match)
	{
		int index = -1;
		if (match.isEmpty() || str1.isEmpty())
		{
			index = 0;
			return index;
		}
		for (int i = 0; i < str1.length(); i++)
		{
			int m = i;
			for (int j = 0; j < match.length(); j++)
			{
				if (match.charAt(j) == str1.charAt(m))
				{
					if (j == match.length() -1)
					{
						index = i;
						return index;
					}
					m++;
				}
				else
				{
					break;
				}
			}
		}
		return index;
	}
}
