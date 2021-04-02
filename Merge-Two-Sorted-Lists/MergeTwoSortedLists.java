import java.util.*;

public class MergeTwoSortedLists 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("l1 = ");
		String str1 = keyboard.nextLine();
		System.out.print("l2 = ");
		String str2 = keyboard.nextLine();
		LinkedList<Character> lkst1 = new LinkedList<Character>();
		LinkedList<Character> lkst2 = new LinkedList<Character>();
		lkst1 = insert(lkst1, str1);
		lkst2 = insert(lkst2, str2);
		lkst1 = sort(lkst1);
		lkst2 = sort(lkst2);
		for (int i = 0; i < lkst1.size(); i++)
		{
			lkst2.add(lkst1.get(i));
		}
		lkst2 = sort(lkst2);
		
		System.out.println(lkst2);
		
	}
	public static LinkedList<Character> sort(LinkedList<Character> lkst)
	{
		for (int i = 0; i < lkst.size(); i++)
		{
			for (int j = i+1; j < lkst.size(); j++)
			{
				if (Character.getNumericValue(lkst.get(i)) > Character.getNumericValue(lkst.get(j)))
				{
					char temp = lkst.get(i);
					lkst.set(i, lkst.get(j));
					lkst.set(j, temp);
				}
			}
		}
		return lkst;
	}
	public static LinkedList<Character> insert(LinkedList<Character> lkst, String str)
	{
		str = str.replace(",", "");
		for (int i = 0; i < str.length(); i++)
		{
			lkst.add(str.charAt(i));
		}
		return lkst;
	}
}
