import java.util.*;

public class Reverseinteger 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String str = "";
		System.out.print("x = ");
		str = keyboard.nextLine();
		char ngtv = '-';
		boolean ans = false;
		if (str.charAt(0) == ngtv)
		{
			str = str.replace("-", "");
			ans = true;
		}
		StringBuffer strbf = new StringBuffer(str);
		strbf.reverse();
		String temp = strbf.toString();
		int nums = Integer.parseInt(temp);
		if (nums < Math.pow(-2, 31) && nums > Math.pow(2, 31))
		{
			System.out.println("0");
		}
		else if (ans)
		{
			System.out.println("-"+nums);
		}
		else
		{
			System.out.println(nums);
		}
		
		
	}
}
