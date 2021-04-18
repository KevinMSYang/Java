import java.util.*;

public class SearchInRotatedSortedArray 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("nums = ");
		String str = keyboard.nextLine();
		System.out.print("target = ");
		int target = keyboard.nextInt();
		str = str.replace(",", "");
		int[] arr = new int[str.length()];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = Integer.parseInt(Character.toString(str.charAt(i)));
		}
		Random rand = new Random(); //pretend as an unknown pivot
		int k = rand.nextInt(arr.length);

		arr = rotated(arr, k);

		boolean found = false;
		for (int i = 0; i < arr.length; i++)
		{
			if (target == arr[i])
			{
				found = true;
				System.out.println(i);
			}
		}
		if (!found)
		{
			System.out.println("-1");
		}
	}
	
	public static int[] rotated(int[] arr, int k )
	{
		int[] temp = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
		{
			temp[i] = arr[i];
		}
		for (int i = 0, j = k; j < arr.length; i++, j++)
		{
			arr[i] = temp[j];
		}
		int start = arr.length - k;
		for (int i = start, j = 0; i < arr.length && j < k; i++, j++)
		{
			arr[i] = temp[j];
		}
		return arr;
	}
}
