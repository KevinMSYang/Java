import java.util.ArrayList;
import java.util.List;

/* You are given a sorted unique integer array nums
 * A range [a, b] is the set of all integers from a to b (inclusive)
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly
 * That is, each element of nums is covered by exactly on of the ranges, and there is no integer x 
 *  such that x is in one of the ranges but not in nums
 *  
 *  Example:
 *  Input: nums = [0,1,2,4,5,7] Output: [0->2, 4->5, 7]
 *  Input: nums = [0,2,3,4,6,8,9] Output: [0, 2->4, 6, 8->9]
 *  
 *  Strategy:
 *  Create an empty ArrayList, use for loop for entire array.length
 *  while current index + 1 is less than array.length && those two number should be equal
 *  Then index move on
 *  Else set the index as end
 *  Final, add the value into arraylist
 */

public class SummaryRanges 
{
	public static void main(String args[])
	{
		int[] nums = {0,2,3,4,6,8,9};
		System.out.println(summaryRanges(nums));
	}
	public static List<String> summaryRanges(int[] nums)
	{
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < nums.length; i++)
		{
			final int begin = nums[i];
			while (i + 1 < nums.length && nums[i] == nums[i + 1] -1)
			{
				i++;
			}
			final int end = nums[i];
			if (begin == end)
			{
				ans.add("" + begin);
			}
			else
			{
				ans.add("" + begin + "->" + end);
			}
		}
		return ans;
	}
}
