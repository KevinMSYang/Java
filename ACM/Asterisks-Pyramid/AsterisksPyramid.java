import java.util.*;
/* input n = Integer
 * output print pyramid
 * exapmle: n = 4
 *    *
 *   * *
 *  *   *
 * *******
 */

public class AsterisksPyramid 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("n = ");
		int n = keyboard.nextInt();
		
		ArrayList<String> arrlst = new ArrayList<String>();
		int x = n;
		int y = n;
		for (int i = 0; i < n; i++)
		{
			String temp1 = String.valueOf(n-i);
			arrlst.add(temp1+","+temp1);
			if (i >= 1)
			{
				String temp2 = String.valueOf(x+i);
				arrlst.add(temp2+","+temp1);
			}	
		}
		int sum = 1;
		for (int i = 0; i < n-2; i++)
		{
			sum += 2;
		}
		for (int i = 0 ; i < sum; i++)
		{
			String temp = String.valueOf(i+2);
			arrlst.add(temp+","+"1");
		}
		System.out.println(arrlst);
		
		String[][] arr = new String[n][(n*2)-1];
		for (int i =0; i < n; i++)
		{
			Arrays.fill(arr[i], " ");
		}
		
		for (int i = 0, j = n-1, k = n-1; i < n; i++, j--, k++)
		{
			arr[i][j] = "*";
			arr[i][k] = "*";
			
		}
		for (int i = 0; i < sum; i++)
		{
			arr[n-1][i+1] = "*";
		}
		
		
		for (int i = 0; i< n; i++)
		{
			for (int j = 0; j < (n*2)-1; j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
