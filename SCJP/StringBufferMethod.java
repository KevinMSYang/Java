
public class StringBufferMethod 
{
	public static void main(String[] args)
	{
		String str = "java";
		StringBuffer sb = new StringBuffer("javachamp");
		
		sb.insert(9, ".com");
		str.concat("champ");
		if (sb.length() < 6 || str.equals("javachamp"))
		{
			System.out.print(sb);
		}
		sb.delete(2, 7);
		System.out.print(sb);
	}
}

/*Question: What is the result of compiling and running the following code?
 * A: javachamp.comjamp.com
 * B: jamp
 * C: jamp.com
 * D: jap
 * 
 * ANS: C
 * Explanation: String.concat means add some words at the end of string, but it need to 
 * assign to original variable then it could be changed
 * StringBuffer.delete(2,7) means include index2 but exclude index 7 which is index 2-6 will be deleted.
 * 
 */
