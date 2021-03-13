import java.util.*;

public class AddTwoNumbers 
{
	/*given two non-empty linked list representing two non negative integers. The digits are stored in reverse order
	 *and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list 
	 *  instance1: L1=[2,4,3] L2=[5,6,4]  >>output: [7,0,8] explanation: 342+465=807
	 */
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		
		String numbers;
		String numbers_1;
		System.out.print("L1=");
		numbers = keyboard.nextLine();
		System.out.print("L2=");
		numbers_1 = keyboard.nextLine();

		String[] temp = new String[numbers.length()];
		String[] temp_1 = new String[numbers_1.length()];
		temp = numbers.split(",");
		temp_1 = numbers_1.split(",");
		int[] cov_int = new int[temp.length];
		int[] cov_int_1 = new int[temp_1.length];
		int idx_l1 = -1;
		int idx_l2 = -1;
		for (int i = 0; i < temp.length; i++)
		{
			cov_int[i] = Integer.parseInt(temp[i]);
			l1.add(cov_int[i]);
			idx_l1++;
		}
		for (int i = 0; i < temp_1.length; i++)
		{
			cov_int_1[i] = Integer.parseInt(temp_1[i]);
			l2.add(cov_int_1[i]);
			idx_l2++;
		}
		int i, j;
		int counter = 0;
		LinkedList<Character> result = new LinkedList<Character>();
		for (i = idx_l1, j = idx_l2; i >=0 || j>=0 ; i--, j--)
		{
			if (i < 0 && j >= 0)
			{
				counter += l2.get(j) * Math.pow(10, j);
			}
			else if (j < 0 && i >= 0)
			{
				counter += l1.get(i) * Math.pow(10, i);
			}
			else
			{
				counter +=(l1.get(i) * Math.pow(10, i)) + (l2.get(j) * Math.pow(10, j));
			}
		}
		String a = Integer.toString(counter);		
		for (int k = a.length()-1; k >= 0; k--)
		{
			result.add(a.charAt(k));
		}
		System.out.println(result);
	}
}
