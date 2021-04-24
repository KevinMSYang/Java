import java.util.*;

public class ZigZagConversion 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String str = "";
		int nRow;
		System.out.print("s = ");
		str = keyboard.nextLine();
		System.out.print("numRows = ");
		nRow = keyboard.nextInt();
		convert(str, nRow);
	}
	public static void convert(String s, int numRows)
	{
		String[] arr = new String[numRows];
		int n = 2 * numRows - 2; 
		
		for (int i = 0; i < s.length(); i++)
		{
			if (i % n < numRows)
			{
				if (arr[i%n] == null)
				{
					arr[i%n] = Character.toString(s.charAt(i));
				}
				else
				{
					arr[i%n] = arr[i%n] + Character.toString(s.charAt(i));
				}
			}
			else
			{
				if (arr[2*numRows - (i%n) -2] == null)
				{
					arr[2*numRows - (i%n) -2] = Character.toString(s.charAt(i));
				}
				else
				{
					arr[2*numRows - (i%n) -2] = arr[2*numRows - (i%n) - 2] + Character.toString(s.charAt(i));
				}
			}
		}
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i]);
		}
	}
}
