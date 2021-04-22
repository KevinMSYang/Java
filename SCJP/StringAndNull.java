
public class StringAndNull 
{
	public static void main(String args[])
	{
		String stmt = null;
		System.out.print(null+stmt);
		System.out.print(stmt+null);
	}
}
/*Question: What is the expected output?
 * A: RuntimeException is thrown because of the first print statement
 * B: RuntimeException is thrown because of the second print statement
 * C: nullnullnullnull
 * D: nullnull
 * E: compilation error
 * 
 * ANS: C
 * Explanation:
 * RuntimeException: are exceptions that can be prevented programmatically
 * i.e. NullPointerException, ArrayIndexOutofBoundException
 * 
 * null cannot print directly, but if a variable point to null then it can be print and also concat
 */
 