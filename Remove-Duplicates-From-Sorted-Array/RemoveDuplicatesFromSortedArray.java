import java.util.*;

public class RemoveDuplicatesFromSortedArray 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("nums = ");
		String nums = keyboard.nextLine();
		String[] temp = nums.split(",");
		int[] arr = new int[temp.length];
		
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = Integer.parseInt(temp[i]);
		}
		int len = removeDuplicates(arr);
		System.out.print(len+ ", nums = ");
		for (int i = 0; i < len; i++)
		{
			if (i == len-1)
			{
				System.out.print(arr[i]);
			}
			else
			{
				System.out.print(arr[i]+",");
			}
		}
	}
	
	public static int removeDuplicates(int[] arr)
	{
		int len = 0;
		int match;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for (int i = 0; i < arr.length; i++)
		{
			match = arr[i];
			for (int j = 0; j < arr.length; j++)
			{
				if (match == arr[j])
				{
					if(!temp.contains(match))
					{
						len++;
						temp.add(match);
					}
				}
			}
		}
		for (int i = 0 ; i < len; i++)
		{
			arr[i] = temp.get(i);
		}
		
		return len;
	}
}
