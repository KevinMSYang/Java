import java.util.*;

public class Safecracker 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int target = 0;
		String str = "";
		ArrayList<String> strarrlst = new ArrayList<String>();
		do
		{
			strarrlst.clear();
			target = keyboard.nextInt();
			str = keyboard.nextLine();
			str = str.replace(" ", "");
			String[] strarr = new String[str.length()];
			String[] data = new String[5];
			strarr = str.split("");
			strarrlst = combinationUnit(strarr, data, 0, strarr.length-1, 0, 5, target, strarrlst);
			if (target != 0 && str != "END")
			{
				if (strarrlst.size() == 1)
				{
					String temp = strarrlst.toString();
					temp = temp.replace("[", "");
					temp = temp.replace("]", "");
					System.out.println(temp);
				}
				else if (strarrlst.size() == 0) 
				{
					System.out.println("no solution");
				}
				else
				{
					String[] temp = new String[strarrlst.size()];
					for (int i = 0; i < temp.length; i++)
					{
						temp[i] = strarrlst.get(i);
					}
					int max = (int)temp[0].charAt(0);
					max = max - 65 +1;
					int max_index = 0;
					for (int i = 0; i< temp.length; i++)
					{
						if (((int)temp[i].charAt(0)) - 65 +1 >= max)
						{
							max = (int)temp[i].charAt(0) - 65 +1;
							max_index = i;
						}
					}
					System.out.println(strarrlst.get(max_index));
				}
			}
		}while(target != 0 && str !="END");
	}
	public static ArrayList<String> combinationUnit(String[] arr, String[] data, int start, int end, int index, int r, int target, ArrayList<String> strarrlst)
	{
		if (index == r)
		{
			StringBuffer strbf = new StringBuffer();
			for (int i = 0; i < data.length; i++)
			{
				strbf.append(data[i]);
			}
			String str = strbf.toString();
			strarrlst = permutation(str, "", target, strarrlst);
			return strarrlst;
		}
		
		for (int i = start; i <= end && end - i + 1 >= r - index; i++)
		{
			data[index] = arr[i];
			combinationUnit(arr, data, i+1, end, index+1, r, target, strarrlst);
		}
		return strarrlst;
	}
	
	public static ArrayList<String> permutation(String str, String ans, int target, ArrayList<String> strarrlst)
	{
		
		if (str.length() == 0)
		{
			int[] arr = new int[ans.length()];
			for (int i = 0; i < ans.length(); i++)
			{
				arr[i] = (int)ans.charAt(i);
				arr[i] = arr[i] - 65 + 1;
			}
			if (arr[0] - Math.pow(arr[1], 2) + Math.pow(arr[2], 3) - Math.pow(arr[3], 4) + Math.pow(arr[4], 5) == target)
			{
				strarrlst.add(ans);
				return strarrlst;
			}
		}
		for ( int i = 0; i < str.length(); i++)
		{
			char ch = str.charAt(i);
			
			String ros = str.substring(0, i) + str.substring(i+1);
			
			permutation(ros, ans+ch, target, strarrlst);
		}
		return strarrlst;
	}
}
