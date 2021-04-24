import java.util.*;

public class SquareDeal 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int[] arr = new int[6];
		int width;
		int length;
		for (int i = 0; i < arr.length; i+=2)
		{
			length = keyboard.nextInt();
			width = keyboard.nextInt();
			if (length <= width)
			{
				arr[i] = width;
				arr[i+1] = length;
			}
			else
			{
				arr[i] = length;
				arr[i+1] = width;
			}
		}
		int x = 0, y = 2, z = 4;
		int temp = 3;
		int index = 0, index_1 = 0, index_2 = 0;
		for (int i = 0; i < 3; i++)
		{
			if (arr[x] > arr[y] && arr[x] > arr[z] && arr[y] == arr[z])
			{
				temp = 0;
				index = x;
				index_1 = y;
				index_2 = z;
				System.out.println("pass 0");
			}
			else if (arr[x] == arr[y] && arr[x] == arr[z])
			{
				temp = 1;
				System.out.println("pass 1");
			}
			else if (arr[x] > arr[y] && arr[x] > arr[z] && arr[x] == arr[y]+arr[z])
			{
				temp = 2;
				index = x;
				System.out.println("pass 2");
			}
			else
			{
				int v = x;
				x = y;
				y = z;
				z = v;
			}
		}
		print(temp, arr, index, index_1, index_2);
	}
	public static void print(int temp, int[] arr, int index, int index_1, int index_2)
	{
		boolean deter = false;
		switch(temp)
		{
		case 0:
			if (arr[index] == arr[index_1+1] + arr[index_2 +1] && arr[index] == arr[index_1] + arr[index+1])
			{
				deter = true;
			}
			break;
		case 1:
			if (arr[1] + arr[3] + arr[5] == arr[0])
			{
				deter = true;
			}
			break;
		case 2:
			int x = 1, y = 3, z = 5;
			for (int i = 0; i < 3; i++)
			{
				if (arr[index] == arr[x] + arr[y])
				{
					deter = true;
				}
				else
				{
					int v = x;
					x = y;
					y = z;
					z = v;
				}
			}
			break;
		case 3:
			deter = false;
			break;
		default:
			
			break;
		}
		
		if (deter)
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
	}
}
