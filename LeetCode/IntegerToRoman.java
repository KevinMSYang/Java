import java.util.*;

public class IntegerToRoman 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("num = ");
		int num = keyboard.nextInt();
		
		IntToRoman(num);
	}
	public static void IntToRoman(int num)
	{
		int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		
		StringBuffer strbf = new StringBuffer();
		for (int i = 0; i < value.length; i++)
		{
			while(num >= value[i])
			{
				num = num - value[i];
				strbf.append(roman[i]);
			}
		}
		System.out.println(strbf.toString());
	}
}
