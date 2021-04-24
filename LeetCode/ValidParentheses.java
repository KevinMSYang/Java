import java.util.*;

public class ValidParentheses 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("s = ");
		String s = keyboard.nextLine();
		String[] temp = s.split("");
		boolean match = true;
		Stack<String> arr = new Stack<String>();
		
		if("".equals(s))
		{
			match = false;
		}
		int arridx = -1;
		int i = 0;
		while(match && i < temp.length)
		{
			if (temp.length % 2 != 0)
			{
				match = false;
			}
			if (temp[i].equals("(") || temp[i].equals("[") || temp[i].equals("{"))
			{
				arr.push(temp[i]);
				i++;
				arridx++;
			}
			else 
			{
				if (arr.get(arridx).equals("(") && temp[i].equals(")"))
				{
					arr.pop();
				}
				else if (arr.get(arridx).equals("[") && temp[i].equals("]"))
				{
					arr.pop();
				}
				else if (arr.get(arridx).equals("{") && temp[i].equals("}"))
				{
					arr.pop();
				}
				else
				{
					match = false;
				}
				arridx--;
				i++;
			}
			if (i >= temp.length && !arr.isEmpty())
			{
				match = false;
			}
		}
		System.out.println(match);
	}
}
