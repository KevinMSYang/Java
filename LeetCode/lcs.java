import java.util.*;
public class lcs 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		// Given any two string for the first input and second string, initialize or prompt user input
		System.out.print("Enter first string: ");
		String s1 = keyboard.next();
		System.out.print("Enter second string: ");
		String s2 = keyboard.next();
	
		//String s1 = "GXTXAYB";							// short example for test result
		//String s2 = "AGGTAB";							
		//String s1 = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";		// long example from text book
		//String s2 = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
		
		// Store each string's length to another variable
		int len1 = s1.length();
		int len2 = s2.length();
		
		// Convert string to char array
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();

		// Print out original two String
		System.out.print("Two input strings are: \n");
		for (int i = 0; i < len1; i++)
		{
			System.out.print(arr1[i]);
		}
		System.out.println();
		for (int i = 0; i < len2; i++)
		{
			System.out.print(arr2[i]);
		}
		
		// Test if two string are empty or not
		emptySet(arr1, arr2, len1, len2);
		
		keyboard.close();
	}
	
	// If one of the string are empty, then return empty set. Otherwise, call lcs method to calculate its Longest Common Subsequence
	public static void emptySet(char[] arr1, char[] arr2, int len1, int len2)
	{
		if (len1 == 0 || len2 == 0)
		{
			System.out.println("Empty Set and its Longest Common Subsequence is 0");
		}
		else
		{
			// Passing two string and their length
			longestcommonSubsequence(arr1, arr2, len1, len2);
		}
	}
	
	// Compare two string with using two for loop and if their character are the same,
	// then 1 + diagonal number in two dimension array  
	public static void longestcommonSubsequence(char[] arr1, char[] arr2, int len1, int len2)
	{
		// Declare two dimension array for storing the result of comparison
		// one for row and column in two dimension array is a easy way to determine either upper or left element should be considered 
		int[][] temp = new int[len1+1][len2+1];
			
		for (int i = 0; i < len1; i++)
		{
			for (int j = 0; j < len2; j++)
			{
				if (arr1[i] == arr2[j])
				{
					// If two character are same, add the diagonal element with 1 
					temp[i+1][j+1] = 1 + temp[i][j];
				}
				else
				{
					// If two characters are different, pick the max value to store it either upper or left element
					temp[i+1][j+1] = max(temp[i][j+1], temp[i+1][j]);
				}
			}
		}
		tracingBack(temp, arr1, arr2, len1, len2);		
	}
	
	//
	public static void tracingBack(int[][] temp, char[] arr1, char[] arr2, int len1, int len2)
	{
		int index = temp[len1][len2];
		int length = index;
		
		// Create a character array to store the lcs string
		char[] result = new char[index+1];
		result[index] = ' ';						// Set the terminating character
			
		// Start from the right-most-bottom-most corner and one by one store characters in result[]
		int i = len1;
		int j = len2;
		while (i > 0 && j > 0)
		{
			// If current character in arr1[] and arr2[] are same, then current character is part of LCS
			if (arr1[i-1] == arr2[j-1])
			{
				// Put current character in result
				result[index-1] = arr1[i-1];
				// Reduce value of i, j and index;
				i--;
				j--;
				index--;
			}
			// If not same, then find the larger of two and go in the direction of larger value
			else if (temp[i-1][j] > temp[i][j-1])
			{
				i--;
			}
			else
			{
				j--;
			}
		}
		
		// Print out result
		System.out.println("\nIts Longest Common Subsequence is: ");
		for (int k = 0; k <= length; k++)
		{
			System.out.print(result[k]);			
		}
		System.out.print(" and length is: " + length);
	}
	// Determine which one is max value
	public static int max(int a, int b)
	{
		return (a > b)? a : b;
	}
}
