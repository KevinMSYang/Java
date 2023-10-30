import java.util.Arrays;

/* A sequence of numbers is called an arithmetic progression if the difference between
 * any two consecutive element is the same.
 * Given an array of numbers arr, return true if the array can be rearranged to form an 
 * arithmetic progression. Otherwise, return false.
 * 
 * Example: 
 * input: arr = [3,5,1] Output: true
 * input: arr = [1,2,4] Output: false
 */
public class CanMakeArithmeticProgressionFromSequence 
{
	public static void main(String args[])
	{
		int[] arr = {1,2,4};
		System.out.println(canMakeArithmeticProgression(arr)? "true": "false");
	}
	
	public static boolean canMakeArithmeticProgression(int[] arr)
	{
		Arrays.sort(arr);
		int difference = Math.abs(arr[1] - arr[0]);
		for (int i = 2; i < arr.length; i++)
		{
			if (arr[i] - arr[i-1] != difference)
			{
				return false;
			}
		}
		return true;
	}
}
