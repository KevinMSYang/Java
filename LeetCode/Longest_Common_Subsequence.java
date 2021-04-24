import java.util.*;

public class Longest_Common_Subsequence 
{
	/*Longest Common Subsequence
	 * two input string, compare the subsequence
	 * instance: "ABCDGH" and "AEDFHR" > LCS = "ADH"
	 * instance2: "AGGTAB" and "GXTXAYB" > LCS = "GTAB"
	 */
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String str;
		
		System.out.print("Enter the first string: " );
		str = keyboard.nextLine();
		char[] arr1 = new char[str.length()];
		for (int i = 0; i< str.length(); i++)
		{
			arr1[i] = str.charAt(i);
		}
		System.out.println();
		System.out.print("Enter the second string: ");
		str = keyboard.nextLine();
		char[] arr2 = new char[str.length()];
		for (int i = 0; i < str.length(); i++)
		{
			arr2[i] = str.charAt(i);
		}
		
		System.out.println("first: ");
		for (int i = 0; i < arr1.length; i++)
		{
			System.out.print(arr1[i]+",");
		}
		System.out.println("\nsecond: ");
		for (int i = 0; i < arr2.length; i++)
		{
			System.out.print(arr2[i]+",");
		}
		
		
	}
}
