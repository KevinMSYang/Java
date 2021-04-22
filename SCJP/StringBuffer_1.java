
public class StringBuffer_1 
{
	public static  void main(String[] args)
	{
		String s = "";
		Integer x = 5;
		StringBuffer sb = new StringBuffer();
		
		if (x < 15)
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
/*Question: What is the result of compiling and running following code?
 * A: javachamp
 * B: javachamp javachamp
 * C: No output is produced
 * D: Compilation error
 * 
 * ANS: C
 * Explanation: Integer and int are both used to store integer type data 
 * the major difference between both is type of int is primitive while 
 * Integer is of class type
 * String.concat(String) need to assign
 */

