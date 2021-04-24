import java.util.*;

public class CountAndSay 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("n = ");
		int n = keyboard.nextInt();
		String str = "";
		for (int i = 1; i <= n; i++)
		{
			str = countAndSay(str);
		}
		System.out.println(str);
	}
	
	public static String countAndSay(String n)
	{
		String str = "";
		StringBuffer strbf = new StringBuffer();
		int count = 0;
		int i = 0, j = 0;
		
		if (n.isEmpty())
		{
			strbf.append(String.valueOf(1));
		}
		else
		{
			while( j < n.length())
			{
				if (n.charAt(i) == n.charAt(j))
				{
					count++;
					j++;
				}
				else
				{
					strbf.append(count);
					strbf.append(Character.toString(n.charAt(i)));
					count = 0;
					i = j;
				}
				
			}
			strbf.append(count);
			strbf.append(Character.toString(n.charAt(i)));
		}
		
		str = strbf.toString();
		return str;
	}
}
