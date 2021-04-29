import java.util.*;

public class JumpGameII 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("nums = ");
		String str = keyboard.nextLine();
		String[] temp = str.split(",");
		int[] temp_int = new int[temp.length];
		for (int i = 0; i < temp_int.length; i++)
		{
			temp_int[i] = Integer.parseInt(temp[i]);
		}
		int[] arr = sortAndRemove(temp_int);
		System.out.println(jump(arr));
	}
	
	public static int[] sortAndRemove(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = i + 1; j < arr.length; j++)
			{
				if (arr[j-1] > arr[j])
				{
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		ArrayList<Integer> arlst = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++)
		{
			if(!arlst.contains(arr[i]))
			{
				arlst.add(arr[i]);
			}
		}
		int[] array = new int[arlst.size()];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = arlst.get(i);
		}
		return array;
	}
	public static int jump(int[] nums)
	{
		if (nums == null || nums.length < 2)
		{
			return 0;
		}
		int res = 0;
		int curMaxArea = 0;
		int maxNext = 0;
		for (int i = 0; i < nums.length-1; i++)
		{
			maxNext = Math.max(maxNext, i + nums[i]);
			if (i == curMaxArea)
			{
				res++;
				curMaxArea = maxNext;
			}
		}
		return res;
	}
}
