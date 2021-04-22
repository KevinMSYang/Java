
public class StringBuffer_2 
{
	public static void main(String[] args)
	{
		String s = "";
		Integer x = 5;
		StringBuffer sb = "";
		
		if (x < 0)
		{
			s.concat("javachamp");
		}
		else
		{
			sb.append("javachamp");
		}
		System.out.print(s+sb);
	}
}
/*Question: What is the result of compiling and running the following code?
 * A: javachamp
 * B: javachamp javachamp
 * C: No output is produced
 * D: Compilation error
 * 
 * ANS: D
 * Explanation: StringBuffer is a Class need to use = new StringBuffer() to declare
 */