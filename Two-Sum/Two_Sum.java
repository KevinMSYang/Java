import java.util.*;

public class Two_Sum 
{
	/*Question:
	 *Given an array of integers nums and an integer target, return indices of the two numbers such as that they add up to target 
	 *assume each input would have exactly one solution, and you may not use the same element twice
	 *example1: nums=[2,7, 11, 15], target = 9 >> Output:[0, 1]
	 *example2: nums=[3, 2, 4], target = 6 >> Output: [1, 2]
	 */
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		// calculate elapse time
		long start = System.nanoTime();
		
		// read nums and target
		String nums = keyboard.nextLine();
		int target = keyboard.nextInt();
		
		// convert to int[]
		String[] temp = new String[nums.length()];
		temp = nums.split(", ");
		int[] array = new int[temp.length];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = Integer.parseInt(temp[i]);
		}
		
		int[] ans = new int[2];
		ans = findMatch(array, target);
		// find two sum
		System.out.println("["+ans[0]+","+ans[1]+"]");
		
		//elapsed time in nano second 
		long end = System.nanoTime();
		long elapsedTime = end - start;
		System.out.println(elapsedTime+ " nano second");
	}
	
	public static int[] findMatch(int[] arr, int target)
	{
		int[] result = new int[2];
		int counter = 0;
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = i+1; j < arr.length; j++)
			{
				if (counter == 0)
				{
					if (arr[i]+arr[j] == target)
					{
						result[0] = i;
						result[1] = j;
						counter++;
						return result;
					}
				}
			}
		}
		return result;
	}
}
