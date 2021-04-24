import java.util.*;

public class LS_without_RepeatingChar 
{
	/*Given a string s, find the length of the longest substring without repeating characters
	 *example1: s = abcabcbb >> 3  explanation abc length = 3
	 *example2: s = pwwkew >> 3 explanation wke length = 3  and pwke is subsequence not substring
	 */
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String s = ""; 
		System.out.print("s = ");
		s = keyboard.nextLine();
		int sub_size = 0;
		ArrayList<String> str = new ArrayList<String>();
		String[] temp = new String[s.length()];
		temp = s.split("");

		int current_size = 0;
		for (int i = 0; i < temp.length; i++)
		{
			if (!str.contains(temp[i]))
			{
				str.add(temp[i]);
				current_size += 1;
			}
			else
			{
				str.clear();
				if (current_size > sub_size)
				{
					sub_size = current_size;
				}
				current_size = 0;
				str.add(temp[i]);
				current_size += 1;
			}
		}
		System.out.println(sub_size);
	}
}
