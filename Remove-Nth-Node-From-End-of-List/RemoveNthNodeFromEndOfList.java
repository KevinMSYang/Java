import java.util.*;

public class RemoveNthNodeFromEndOfList 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		LinkedList<Integer> lkst = new LinkedList<Integer>();
		System.out.print("head = ");
		String str = keyboard.nextLine();
		System.out.print("n = ");
		int n = keyboard.nextInt();
		String[] temp = str.split(",");
		for (int i = 0; i < temp.length; i++)
		{
			lkst.add(Integer.parseInt(temp[i]));
		}
		lkst.remove(temp.length-n);
		System.out.println(lkst);
	}
}
