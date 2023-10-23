/* Given an integer n, return true if it is a power of four. 
 * Otherwise, return false.
 * An integer n is a power of four, if there exists an integer x such that n == 4^x
 * 
 * Example : input n = 16, Output: true
 * Example : input n = 5, Output: false
 * 
 * Strategy: keep decrease the n number until it reach n = 1.
 */

public class PowerOfFour 
{
	public static void main(String args[])
	{
		
	}
	
	public static boolean isPowerOfFour(int n)
	{
		if (n == 0)
		{
			return false;
		}
		while ( n != 1)
		{
			if (n % 4 != 0)
			{
				return false;
			}
			n = n / 4;
		}
		return true;
	}
}
