public class String_Tester 
{	
	public static void main(String[] args)
	{
		String stmt = "JavaChamp is here to help you";
		for (String token: stmt.split("//s"))
		{
			System.out.print(token + " ");
		}
	}
}

/* Question: What is the result of compiling and running the following code?
 * A: JavaChamp is here to help you
 * B: JavaChamp i here to help you
 * C: No output is produced
 * D: Compliation errpr
 * 
 * ANS: A
 * Explanation: \\s : means white space and \\S means match any non-white space character 
 * The question above is //s, so it did not match anything, hence, it does not split.
 */
