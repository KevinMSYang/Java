import java.util.*;

public class ContainerWithWater 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("height = ");
		String height = keyboard.nextLine();
		
		String[] str = height.split(",");
		int[] arr = new int[str.length];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = Integer.parseInt(str[i]);
		}
		
		int area = 0;
		if (arr.length <= 1)
		{
			System.out.println("0");
		}
		else
		{
			for (int i = 0; i < arr.length; i++)
			{
				for (int j = arr.length-1; j >= 0; j--)
				{
					int length = j - i;
					if (arr[i] > arr[j])
					{
						if (area < arr[j] * length)
						{
							area = arr[j] * length;
						}
					}
					else 
					{
						if (area < arr[i] * length)
						{
							area = arr[i] * length;
						}
					}		
				}
			}
		}
		System.out.println(area);
	}
}
