
public class FlowControl 
{
	public static void main(String[] args)
	{
		int j = 10;
		switch(1)
		{
		case 20:
			j +=1;
			System.out.println("20");
		case 40:
			j +=2;
			System.out.println("40");
		default:
			j += 3;
			System.out.println("default");
		case 0:
			j +=4;
			System.out.println("0");
		}
		System.out.println(j);
	}
}

/*Question: What is the result of compiling and running the following code?
 * A: Compile error, cant use constant 1 in the switch, much be final variable
 * B: Compile error, default must be the last statement after all the cases
 * C: Compile error, must have break statement within each case
 * D: 17
 * E: 13
 * 
 * ANS: D
 * Explanation:
 *  match dafault then go to j+=3 
 *  since no break so go to next statement j+=4
 */