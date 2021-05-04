import java.util.*;

public class Pow 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("x = ");
		double x = keyboard.nextDouble();
		System.out.print("n = ");
		int n = keyboard.nextInt();
		System.out.println(myPow(x,n));
	}
	public static double myPow(double x, int n)
	{
		if (n > 0)
		{
			return pow(x,n);
		}
		else
		{
			return 1.0/pow(x, n*-1);
		}
	}
	public static double pow(double x, int n)
	{
		if (n == 0)
		{
			return 1;
		}
		double y = pow(x, n/2);
		if (n%2==0)
		{
			return y*y;
		}
		else
		{
			return y*y*x;
		}
	}
}
