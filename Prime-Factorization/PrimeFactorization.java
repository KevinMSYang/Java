import java.util.*;

public class PrimeFactorization 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("n = ");
		int n = keyboard.nextInt();
		int[] num = new int[n];
		int[] power = new int[n];
		int counter = 0;
		int temp = n;
		for (int i = 2; i < n; i++)
		{
			while(n%i == 0)
			{
				counter++;
				n = n / i;
			}
			if (counter > 0)
			{
				num[i] = i;
				power[i] = counter;
				counter = 0;
			}
		}
		for (int i = 0 ; i < temp; i++)
		{
			if (power[i] > 0)
			{
				System.out.print(num[i]+ "^"+power[i] + ",");
			}
		}
		if (n > 2)
		{
			System.out.print(n);
		}
	}
}
