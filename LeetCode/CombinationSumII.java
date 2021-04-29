import java.util.*;

public class CombinationSumII 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("candidates = ");
		String str = keyboard.nextLine();
		System.out.print("target = ");
		int target = keyboard.nextInt();
		
		String[] temp = str.split(",");
		int[] arr = new int[temp.length];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = Integer.parseInt(temp[i]);
		}
		System.out.println(combinationSum(arr, target));
	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target)
	{
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0)
		{
			return res;
		}
		Arrays.sort(candidates);
		helper(res, new ArrayList<>(), candidates, target, 0);
		return res;
	}
	public static void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start)
	{
		if (target < 0)
		{
			return;
		}
		if (target == 0)
		{
			if (!res.contains(list))
			{
				res.add(new ArrayList<>(list));
			}
			return;
		}
		for (int i = start; i < candidates.length; i++)
		{
			list.add(candidates[i]);
			helper(res, list, candidates, target-candidates[i], i+1);
			list.remove(list.size() - 1);
		}
	}
}
