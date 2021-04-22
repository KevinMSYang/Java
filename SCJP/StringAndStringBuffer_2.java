
public class StringAndStringBuffer_2 
{
	public static void main(String[] args)
	{
		StringBuffer sb = new StringBuffer("javachamp");
		String s = new String("javachamp");
		
		boolean stmt1 = s.equals(sb);
		boolean stmt2 = sb.equals(s);
		boolean stmt3 = sb.toString() == s;
		boolean stmt4 = sb.toString().equals(s);
		boolean stmt5 = s.equals(sb.toString());
		
	}
}
/*Question: Which of the statements would evaluate to true?
 * A: stmt1
 * B: stmt2
 * C: stmt3
 * D: stmt4
 * E: stmt5
 * 
 * ANS: D,E
 * Explanation: check StringAndBuffer_1
 */
