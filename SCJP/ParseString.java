import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseString 
{
	public static void main(String[] args)
	{
		Pattern p = Pattern.compile("[a-f]\\d+");
		Matcher m = p.matcher("ab34ef0");
		while (m.find())
		{
			System.out.print(m.start() +" " + m.group());
		}
	}
}
/*Question: Given the following code, what is the expected output?
 * A: 0 ab345 f0
 * B: 0 ab344 ef0
 * C: 1 b35 f0
 * D: 1 b345 f0
 * 
 * ANS: D
 * Explanation: regular expression [a-f]: any character from a - f
 * \\d : digit from 0-9 
 * + : one or more
 * m.start(): return the first index that match pattern
 * m.group(): return the subsequence matched by the previous match result
 * 
 */

 