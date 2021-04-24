import java.util.*;

public class SearchInsertPosition 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("nums = ");
		String nums = keyboard.nextLine();
		System.out.print("target = ");
		int target = keyboard.nextInt();
		
		int index = 0;
		if ("".equals(nums))
		{
			System.out.println(index);
		}
		else
		{
			String[] str = nums.split(",");
			int[] arr = new int[str.length];
			for (int i = 0; i < arr.length; i++)
			{
				arr[i] = Integer.parseInt(str[i]);
			}
			
			for (int i = 0; i < arr.length; i++)
			{
				if (arr[i] == target)
				{
					index = i;
				}
				else if (target > arr[i])
				{
					index = i+1;
				}
			}
		}
		System.out.println(index);
	}
}
