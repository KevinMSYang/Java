import java.util.*;

public class RomanToInteger 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("s = ");
		String s = keyboard.nextLine();
		s = s.toUpperCase();
	
		int counter = s.length();
		String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		int sum = 0;
		int i = 0;
		while (counter != 0)
		{
			if (i >= roman.length)
			{
				i = 0;
			}
			if(s.startsWith(roman[i]))
			{
				sum = sum + value[i];
				if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11)
				{
					s = s.substring(2);
					counter -= 2;
				}
				else
				{
					s = s.substring(1);
					counter--;
				}
			}
			i++;
		}
		System.out.println(sum);
	}
}
