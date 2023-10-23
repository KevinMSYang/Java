
/* Design a parking system for a parking lot. The parking lot has three kinds of parking spaces
 * big, medium, and small, with a fixed number of slots for each size.
 * Implement the 
 * 
 */
public class DesignParkingSystem 
{
	int big, medium, small;
	public static void main(String args[])
	{
		
	}
	
	public DesignParkingSystem(int big, int medium, int small)
	{
		this.big = big;
		this.medium = medium;
		this.small = small;
	}
	public boolean addCar(int carType)
	{
		if (carType == 1)
		{
			if (big == 0)
			{
				return false;
			}
			big--;
		}
		else if (carType == 2)
		{
			if (medium == 0)
			{
				return false;
			}
			medium--;
		}
		else
		{
			if (small == 0)
			{
				return false;
			}
			small--;
		}
		return true;
	}
}
