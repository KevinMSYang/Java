import java.util.*;

public class PermutationII 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("nums = ");
		String str = keyboard.nextLine();
		str = str.replace("[", "");
		str = str.replace("]", "");
		String[] temp = str.split(",");
		int[] nums = new int[temp.length];
		for (int i = 0; i < nums.length; i++)
		{
			nums[i] = Integer.parseInt(temp[i]);
		}
		System.out.print(permute(nums));
	}
	public static List<List<Integer>> permute(int[] nums)
	{
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length ==0 )
		{
			return res;
		}
		Arrays.sort(nums);
		helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
		return res;
	}
	
	public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used)
	{
		if (list.size() == nums.length)
		{
			res.add(new ArrayList<>(list));
		}
		for (int i = 0; i < nums.length; i++)
		{
			if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1])
			{
				continue;
			}
			used[i] = true;
			list.add(nums[i]);
			helper(res, list, nums, used);
			used[i] = false;
			list.remove(list.size() -1 );
		}
	}
}
