import java.awt.List;
import java.util.*;

public class Longest_increasing_subsequence 
{
	/* Longest Increasing Subsequence
	 * given several numbers into array
	 * calculate the longest increasing subsequence 
	 * answer may not be unique
	 */
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		int number;
		do
		{
			System.out.print("Enter several integer number(Enter -1 for quit entering): ");
			number = keyboard.nextInt();
			if (number != -1)
			{
				arr.add(number);
			}
		}while(number != -1);
		
		ArrayList<Integer> lis = new ArrayList<Integer>();
		Integer[] array = new Integer[arr.size()];
		array = arr.toArray(array);
		
		int min = array[0];
		lis.add(min);
		int current_index = 0;
		for (int i = 1; i < array.length; i++)
		{
			if (min > array[i])
			{
				if (lis.get(current_index-1) > array[i])
				{
					min = array[i-1];
				}
				else
				{
					min = array[i];
					lis.set(current_index, array[i]);
				}
			}
			else
			{
				lis.add(array[i]);
				min = array[i];
				current_index++;
			}
		}
		System.out.println("LIS: " + lis);
	}
}
