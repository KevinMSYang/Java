import java.util.*;

public class LetterCombinationsOfaPhoneNumber 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("digits = ");
		String str = keyboard.nextLine();
		String[] temp = str.split("");
		String[] button = {"2", "3", "4", "5", "6", "7", "8", "9"};
		String[] alph = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ArrayList<String> strlst = new ArrayList<String>();
		
		for (int i = 0; i < temp.length; i++)
		{
			for (int j = 0; j < button.length; j++)
			{
				if (temp[i].equals(button[j]))
				{
					temp[i] = alph[j];
				}
			}
		}
		if (temp.length == 1)
		{
			for (int i = 0; i < temp[0].length(); i++)
			{
				strlst.add(Character.toString(temp[0].charAt(i)));
			}
		}
		else
		{
			for (int i = 0; i < temp.length; i++)
			{
				for (int j = i +1; j < temp.length; j++)
				{
					strlst = combination(temp[i], temp[j], strlst);
				}
			}
		}
		
		System.out.println(strlst);
	}
	public static ArrayList<String> combination(String str1, String str2, ArrayList<String> strlst)
	{
		for (int i = 0; i < str1.length(); i++)
		{
			for (int j = 0; j < str2.length(); j++)
			{
				String tempstr = Character.toString(str1.charAt(i))+Character.toString(str2.charAt(j));
				strlst.add(tempstr);
			}
		}
		return strlst;
	}
}
