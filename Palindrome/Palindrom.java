import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Palindrom 
{
	// return palindrome number or string
	 
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		String nums = keyboard.nextLine();
		Pattern p = Pattern.compile("[a-zA-Z]*", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(nums);
		if (m.matches())
		{
			StringPalin(nums);
		}
		else
		{
			int temp = Integer.parseInt(nums);
			NumericalPalin(temp);
		}
	}
	
	public static void NumericalPalin(int nums)
	{
		int r, sum = 0;
		int temp = nums;
		while(nums > 0)
		{
			r = nums % 10;
			sum = (sum*10) + r;
			nums = nums / 10;
		}
		if (temp == sum)
		{
			System.out.println("Palindrome Numbers");
		}
		else
		{
			System.out.println("Non-Palindrome Numbers");
		}
	}
	
	public static void StringPalin(String str)
	{
		StringBuffer s = new StringBuffer(str);
		String restr = s.reverse().toString();
		
		if (str.equalsIgnoreCase(restr))
		{
			System.out.println("Palindrome Strings");
		}
		else
		{
			System.out.println("Non-Palindrome Strings");
		}
	}
}
