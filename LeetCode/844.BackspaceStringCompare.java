
/* Given two strings s and t, return true if theyh are equal when both are typed into empty
 * text editors. '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty
 * 
 * Strategy: find the index of '#' and use substring, or string buffer to delete the original string
 */

public class BackspaceStringCompare 
{
	public static void main(String args[])
	{
		System.out.println(backspaceCompare("ab##" ,"c"));
		
	}
	public static boolean backspaceCompare(String s, String t)
	{
		while (s.contains("#"))
		{
			int backspace = s.indexOf('#');
			if (s.length() > 1)
			{
				/* substring, (included, excluded)
				 * 
				 */
				s = s.substring(0, backspace-1) + s.substring(backspace+1, s.length());
			}
			else
			{
				s = s.substring(0, backspace-1);
			}
		}
		
		while (t.contains("#"))
		{
			int backspace = s.indexOf('#');
			if (s.length() > 1)
			{
				s = s.substring(0, backspace-1) + s.substring(backspace+1, s.length());
			}
			else
			{
				s = s.substring(0, backspace-1);
			}
		}
		if (s.equalsIgnoreCase(t))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
