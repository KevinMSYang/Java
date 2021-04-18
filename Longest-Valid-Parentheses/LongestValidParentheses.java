import java.util.*;

public class LongestValidParentheses 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("s = ");
		String s = keyboard.nextLine();
		String[] arr = s.split("");
		Stack<String> str = new Stack<String>();
		int result;
		
		if("".equals(s))
		{
			result = 0;
		}
		else
		{
			result = calculate(str, arr);
		}
		System.out.println(result);
	}
	
	public static int calculate(Stack<String> str, String[] arr)
	{
		int result = 0;
		int strindex = -1;
		ArrayList<Integer> max = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i].equals("("))
			{
				str.push(arr[i]);
				strindex++;
			}
			else
			{
				if (strindex >= 0)
				{
					if (str.get(strindex).equals("(") && arr[i].equals(")"))
					{
						str.pop();
						result += 2;
						strindex--;
					}
				}
				if (arr[i].equals(")") && str.isEmpty())
				{
					max.add(result);
					result = 0;
				}
			}
		}
		max.add(result);
		result = findmax(max);
		return result;
	}
	
	public static int findmax(ArrayList<Integer> arr)
	{
		int max = arr.get(0);
		for (int i = 1; i < arr.size(); i++)
		{
			if (arr.get(i) != 0 && arr.get(i-1) != 0)
			{
				arr.set(i, arr.get(i)+arr.get(i-1));
			}
			if (max < arr.get(i))
			{
				max = arr.get(i);
			}
		}
		return max;
	}
}
