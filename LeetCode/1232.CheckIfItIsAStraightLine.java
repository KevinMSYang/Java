
/* You are given an array coordinates, coordinates[i] = [x,y], where [x,y] represents the 
 * coordinate of a point. Check if these points make a straight line in the XY plane.
 * 
 * Strategy:
 * slope = y1 - y0 / x1 - x0
 * calculate the first two point's slop and compare the third and two point's slop.
 * If it is straight line, the slope should be equal.
 */
public class CheckIfItIsAStraightLine 
{
	public static void main(String args[])
	{
		int[][] coordinates = {{1,2}, {2,3}, {3,4}, {4,5}, {5,6}};
		System.out.println(checkStraightLine(coordinates)? "ture" : "false");
	}
	
	public static boolean checkStraightLine(int[][] coordinates)
	{
		if (coordinates.length == 2)
		{
			return true;
		}
		int x0 = coordinates[0][0], x1 = coordinates[1][0];
		int y0 = coordinates[0][1], y1 = coordinates[1][1];
		/* first two point's slope: y1 - y0/ x1 - x0
		 * third and two point's slope: y2 - y1/ x2 - x1
		 * So: (y1-y0)/(x1-x0) = (y2-y1)/(x2-x1)
		 * which is (y2-y1)*(x1-x0) = (y1-y0)*(x2-x1)
		 */
		int dx = x1 - x0;
		int dy = y1 - y0;
		for (int i = 2; i < coordinates.length; i++)
		{
			int xi = coordinates[i][0];
			int yi = coordinates[i][1];
			if (dx * (yi - y1) != dy * (xi - x1))
			{
				return false;
			}
		}
		return true;
	}
}
