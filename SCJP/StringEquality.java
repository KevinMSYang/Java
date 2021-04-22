
public class StringEquality 
{
	public static void main(String[] args)
	{
		String a = "javachamp";
		String b = "javachamp";
		String c = new String("javachamp");
		
		System.out.print(a==b);
		System.out.print(a==c);
		System.out.print(b.equals(c));
		System.out.print(b.equals(a));
	}
}
/*Question: What is the result of compiling and running the following program?
 * A: Compilation error
 * B: falsefalsetruetrue
 * C: truetruetruetrue
 * D: truefalsetureture
 * 
 * ANS: D
 * Explanation: == operator compare the reference location and it seems like String a and b are 
 * are point to the same memory location
 */
 