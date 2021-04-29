import java.util.*;

public class Permutations 
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
		System.out.println(permute(nums));
	}
	public static List<List<Integer>> permute(int[] nums)
	{
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
		{
			return res;
		}
		helper(res, new ArrayList<>(), nums);
		return res;
	}
	public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums)
	{
		if(list.size() == nums.length)
		{
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++)
		{
			if (list.contains(nums[i]))
			{
				continue;
			}
			list.add(nums[i]);
			helper(res, list, nums);
			list.remove(list.size()-1);
		}
	}
}
