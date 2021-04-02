import java.util.*;

public class ThreeSum 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("nums = ");
		String str = keyboard.nextLine();
		String[] temp = str.split(",");
		int[] arr = new int[temp.length];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = Integer.parseInt(temp[i]);
		}
		int[] index = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
		{
			index[i] = i;
		}
		int r = 3;
		int n = index.length;
		ArrayList<String> arrlst = new ArrayList<String>();
		arrlst = print(index, n, r, arrlst, arr);
		System.out.println(arrlst);
	}
	public static ArrayList<String> print(int[] index, int n, int r, ArrayList<String> arrlst, int[] arr)
	{
		int[] data = new int[r];
		combination(index, data, 0, n-1, 0, r, arrlst, arr);
		return arrlst;
	}
	public static ArrayList<String> combination(int[] index, int[] data, int start, int end, int curr, int r, ArrayList<String> arrlst, int[] arr)
	{
		if (curr == r)
		{
			if (arr[data[0]] + arr[data[1]] + arr[data[2]] == 0)
			{
				StringBuffer strbf = new StringBuffer();
				for (int i = 0; i < data.length; i++)
				{
					if(i == 2)
					{
						strbf.append(arr[data[i]]);
					}
					else
					{
						strbf.append(arr[data[i]]+ ",");
					}
				}
				arrlst.add(strbf.toString());
			}
			return arrlst;
		}
		for (int i = start; i <= end && end-i+1 >= r-curr; i++)
		{
			data[curr] = index[i];
			combination(index, data, i+1, end, curr+1, r, arrlst, arr);
		}
		return arrlst;
	}
}
