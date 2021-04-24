import java.util.*;

public class LongestPalindromicSubstring 
{
	// Given a string s, return the longest palindromic substring in s
	 
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		StringBuffer s = new StringBuffer();
		System.out.print("s = ");
		String str = keyboard.nextLine();
		int currentlen = 0;
		int maxlen = 0;
		char temp = str.charAt(0);
		String maxsubstring = Character.toString(temp);

		for (int i = 0; i < str.length(); i++)
		{
			s.append(str.charAt(i));
			for (int j = i+1; j < str.length(); j++)
			{
				s = s.append(str.charAt(j));
				if (palin(s))
				{
					currentlen = s.length();
					if (currentlen >= maxlen)
					{
						maxlen = currentlen;
						maxsubstring = s.toString();
					}
				}
			}
			s.delete(0, str.length());
		}
		System.out.println(maxsubstring);
	}
	public static boolean palin(StringBuffer s2)
	{
		String str = s2.toString();
		boolean ans = false;
		String counter = new StringBuffer(s2).reverse().toString();
		if (counter.equals(str))
		{
			ans = true;
		}
		return ans; 
	}
}
