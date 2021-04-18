import java.util.*;

public class FindFirstAndLastPositionofElementInSortedArray 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("nums = ");
		String nums = keyboard.nextLine();
		System.out.print("target = ");
		int target = keyboard.nextInt();
		
		int[] index  = new int[2];
		if ("".equals(nums))
		{
			index[0] = -1;
			index[1] = -1;
		}
		else
		{
			String[] temp = nums.split(",");
			int[] arr = new int[temp.length];
			for (int i = 0; i < arr.length; i++)
			{
				arr[i] = Integer.parseInt(temp[i]);
			}
			index[0] = first(arr, target, 0, arr.length-1, arr.length);
			index[1] = last(arr, target, 0, arr.length-1, arr.length);
		}
		
		System.out.println("["+index[0]+","+index[1]+"]");
	}
	public static int first(int[] arr, int key, int low, int high, int len)
	{
		if (high >= low)
		{
			int mid = low + (high - low)/2;
			if ((mid == 0 || key > arr[mid -1]) && arr[mid] == key)
			{
				return mid;
			}
			else if (key > arr[mid])
			{
				return first(arr, key, mid+1, high, len);
			}
			else
			{
				return first(arr, key, low, mid-1, len);
			}
		}
		return -1;
	}
	public static int last(int[] arr, int key, int low, int high, int len)
	{
		if(high >= low)
		{
			int mid = low + (high - low)/2;
			if((mid == len-1 || key < arr[mid +1]) && arr[mid] == key)
			{
				return mid;
			}
			else if(key < arr[mid])
			{
				return last(arr, key, low, mid-1, len);
			}
			else
			{
				return last(arr, key, mid+1, high, len);
			}
		}
		return -1;
	}
}
