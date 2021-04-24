import java.util.*;

public class GolombSequence 
{
	/* Golomb Sequence
	 * a(1) = 1
	 * a(n+1) = 1+a(n+1 - a(a(n)))
	 * instance: 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 11,
11, 11, 11, 11, 12, 12, 12, 12, 12, 12
	 */
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		int number;
		System.out.print("Enter a number then indicate Golmb Sequence number: ");
		number = keyboard.nextInt();
		System.out.println();
		for (int i = 1; i <= number ; i++)
		{
			System.out.print(findGolomb(i)+ ", ");
		}
		
	}
	
	public static int findGolomb(int n)
	{
		if (n == 1)
		{
			return 1;
		}
		else
		{
			return 1 + (findGolomb((n-1)+1 - findGolomb(findGolomb(n-1))));
		}
	}
}
