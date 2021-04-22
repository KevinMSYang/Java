import java.util.*;

public class useScanner 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner("javachamp 2009, true 239");
		while(sc.hasNext())
		{
			if (sc.hasNextBoolean())
			{
				System.out.print("Boolean");
			}
			if (sc.hasNextInt())
			{
				System.out.print("Int");
			}
			sc.next();
		}
	}
}

/*Question : What is the result of compiling and running the following code?
 * A: IntBooleanInt
 * B: BooleanInt
 * C: IntInt
 * D: Compilation error
 * 
 * ANS: B
 * Explanation: hasNextBoolean means sc.next is true if only if it can represent as boolean data type
 * hasNextInt means sc,next is true if only if it can represent as int data type
 * 
 * javachamp > boolean false
 * javachamp > int false
 * 2009, > boolean true
 * 2009, > int false
 * true > boolean false
 * true > int true
 * 239 > boolean false
 * 239 > int false
 */
