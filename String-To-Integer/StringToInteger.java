import java.util.*;
import java.util.regex.*;
import java.math.BigInteger;

public class StringToInteger
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("s = ");
		String str = keyboard.nextLine();
		char sign = ' ';
		int k = 0;
		boolean counter = true;
		StringBuffer strbf = new StringBuffer();
		
		while (counter && k < str.length())
		{
			if (str.charAt(k) == ' ')
			{
				str = str.replace(" ", "");
			}
			if(str.charAt(k) == '-' || str.charAt(k) == '+')
			{
				sign = '-';
				str = str.replace("-", "");
			}
			if (Pattern.matches("[a-z]", Character.toString(str.charAt(k))))
			{
				counter = false;
			}
			if (Pattern.matches("[0-9]", Character.toString(str.charAt(k))))
			{
				strbf.append(str.charAt(k));
				k++;
			}
		}
		
		if (strbf.length() == 0)
		{
			System.out.println(0);
		}
		else
		{
			BigInteger nums = new BigInteger(strbf.toString());
			if (sign == '-')
			{
				BigInteger n = BigInteger.valueOf(-1);
				BigInteger low = BigInteger.valueOf((long) Math.pow(-2, 31));
				nums = nums.multiply(n);
				if (nums.compareTo(low) == -1) 
				{
					System.out.println(Math.pow(-2, 31));
				}
				else 
				{
					int orig_nums = Integer.parseInt(strbf.toString());
					orig_nums = orig_nums * -1;
					System.out.println(orig_nums);
				}
				
			}
			else
			{
				BigInteger max = BigInteger.valueOf((long) Math.pow(2, 31) -1);
				if (nums.compareTo(max) == 1)
				{
					System.out.println(Math.pow(2, 31) -1);
				}
				else
				{
					int orig_nums = Integer.parseInt(strbf.toString());
					System.out.println(orig_nums);
				}
			}
		}
	}
}
