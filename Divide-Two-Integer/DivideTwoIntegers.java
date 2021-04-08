import java.util.*;

public class DivideTwoIntegers 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("dividend = ");
		int dividend = keyboard.nextInt();
		System.out.print("divisor = ");
		int divisor = keyboard.nextInt();
		int quotient = DivideTwoInt(dividend, divisor);
		System.out.println(quotient);
	}
	public static int DivideTwoInt(int num, int div)
	{
		int quotient = 0;
		
		if ( num < div)
		{
			quotient = 0;
		}
		else if (num > 0 && div > 0 && num != div)
		{
			int count = 0;
			while (num > div)
			{
				num = num - div;
				count++;
			}
			quotient = count;
		}
		else if ( num == div) 
		{
			quotient = 1;
		}
		else
		{
			num = Math.abs(num);
			div = Math.abs(div);
			int count = 0;
			while (num > div)
			{
				num = num - div;
				count++;
			}
			quotient = count - (count+count);
		}
		
		if (quotient > Math.pow(2, 31) -1)
		{
			quotient = (int) (Math.pow(2, 31) -1);
		}
		return quotient;
	}

}
