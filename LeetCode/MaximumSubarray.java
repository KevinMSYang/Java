import java.util.*;

public class MaximumSubarray 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("nums = ");
		String str = keyboard.nextLine();
		String[] temp = str.split(",");
		int[] nums = new int[temp.length];
		for (int i = 0; i < nums.length; i++)
		{
			nums[i] = Integer.parseInt(temp[i]);
		}
		System.out.println(maxSubArray(nums));
	}
	public static int maxSubArray(int[] nums)
	{
		
		int max = 0;
		int current = 0;
		for (int i = 0; i < nums.length; i++)
		{
			current = 0;
			for (int j = i; j < nums.length; j++)
			{
				current += nums[j];
				max = Math.max(max, current);
			}
		}
		return max;
	}
}
