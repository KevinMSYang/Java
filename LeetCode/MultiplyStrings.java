import java.util.*;

public class MultiplyStrings 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("num1 = ");
		String num1 = keyboard.next();
		System.out.print("num2 = ");
		String num2 = keyboard.next();
		System.out.println(multiply(num1, num2));
		
		
	}
	public static String multiply(String num1, String num2)
	{
		if (num1.length() == 0 || num2.length() == 0)
		{
			return "0";
		}
		int[] digit = new int[num1.length() + num2.length()];
		for (int i = num1.length()-1; i >= 0; i--)
		{
			for (int j = num2.length()-1; j >= 0; j--)
			{
				int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int index1 = i + j;
				int index2 = i + j + 1;
				int sum = digit[index2] + product;
				digit[index1] += sum / 10;
				digit[index2] = sum % 10;
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < digit.length; i++)
		{
			if (!(digit[i] == 0 && sb.length() == 0))
			{
				sb.append(digit[i]);
			}
		}
		return sb.toString();
	}
}
