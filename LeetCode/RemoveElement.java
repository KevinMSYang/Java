import java.util.*;

public class RemoveElement 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("nums = ");
		String nums = keyboard.nextLine();
		String[] temp = nums.split(",");
		System.out.print("val = ");
		int val = keyboard.nextInt();
		int[] arr = new int[temp.length];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		int len = removeElement(arr, val);
		System.out.print(len + ", nums = ");
		for (int i = 0 ; i < len ; i++)
		{
			if (i == len -1)
			{
				System.out.print(arr[i]);
			}
			else
			{
				System.out.print(arr[i]+",");
			}
		}
	}
	
	public static int removeElement(int[] arr, int val)
	{
		int len = 0;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for (int i = 0; i < arr.length; i++)
		{
			if (val != arr[i])
			{
				len++;
				temp.add(arr[i]);
			}
		}
		for (int i = 0 ; i < len ; i++)
		{
			arr[i] = temp.get(i);
		}
		
		return len;
	}
}
