import java.util.Arrays;
import java.util.List;

/* Given an integer rowIndex, return the rowIndex^th (O-indexed) row of the Pascal's triangle
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown
 * Example: rowIndex = 3
 * Output: [1,3,3,1]
 * 
 * Strategy:
 * First i = 2 because only when rowIndex is bigger than 3, it required get into loop.
 * back track from it, and add the previous value and itself together
 */

public class PascalsTriangle_2 
{
	public static void main(String args[])
	{
		
	}
	/* Java List is an ordered collection. Java List is an interface that extends Collection interface.
	 * Java List provides control over the position where you can insert an element.
	 * You can access elements by their index and also search in the list.
	 */
	public List<Integer> getRow(int rowIndex)
	{
		/* int[] is an array of primitive int values. 
		 * Integer[] is an "object" array, holding references to integer objects.
		 * Most important practical difference: int[] cannot hold null values.
		 */ 
		Integer[] ans = new Integer[rowIndex +1];
		/* Array.fill: fill in all the number into that array
		 * only for int[], int value
		 */
		Arrays.fill(ans,  1);
		
		for (int i = 2; i < rowIndex +1; i++)
		{
			for (int j = 1; j < i; j++)
			{
				ans[i - j] += ans[i - j - 1];
			}
		}
		/* Arrays.asList() is used to return a fixed-size list backed by the specified array.
		 * This method acts as a bridge between array-based and collection-based APIs, in combination with Collection.
		 */ 
		return Arrays.asList(ans);
	}
}
