
/* Given m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise
 * return the number of negative numbers in grid
 * Example: 
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * 
 */
public class CountNegativeNumbersInASortedMatrix 
{
	public static void main(String args[])
	{
		int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,2},{-1,-1,-2,-3}};
		System.out.println(countNegatives(grid));
	}
	public static int countNegatives(int[][] grid)
	{
		int numbers = 0;
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++)
			{
				if (grid[i][j] < 0 )
				{
					numbers++;
				}
			}
		}
		return numbers;
	}
}
