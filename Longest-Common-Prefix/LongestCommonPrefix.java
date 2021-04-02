import java.util.*;

public class LongestCommonPrefix 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("strs = ");
		String str = keyboard.nextLine();
		String[] arr = str.split(",");
		
		int counter = 0;
		String prefix = arr[0].substring(0, 1);
		boolean match = true;
		int i = 0;
		int j = 1;
		int k = 1;
		String temp = prefix;
		while (match)
		{
			if(!prefix.equalsIgnoreCase(arr[i].substring(0, j)))
			{
				match = false;
			}
			else
			{
				counter++;
			}
			if (counter == arr.length * k)
			{
				temp = prefix;
				k++;
			}
			if(i == arr.length-1)
			{
				j++;
				i = -1;
				prefix = arr[0].substring(0, j);
			}
			i++;
		}
		if (counter < arr.length)
		{
			System.out.println(" ");
		}
		else
		{
			System.out.println(temp);
		}
	}
}
