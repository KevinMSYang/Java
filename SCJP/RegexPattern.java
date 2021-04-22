import java.util.regex.*;

public class RegexPattern 
{
	public static void main(String[] args)
	{
		String regex = "[0-9]*";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher("123456");
		p.compile(regex);
		p.matches(regex, "123456");
		System.out.println(p.toString());
		System.out.println(m.matches());
		System.out.println(m.group());
		System.out.println(m.toString());
	}
}

/*Question: Which of the following methods can be invoked by an object of Pattern class?
 * A: compile
 * B: matches
 * C: group
 * D: toString()
 * 
 * ANS: A,B,D
 * Explanation: 
 * p.compile(): parameters accept regular expression
 * p.matches(): parameters accept a string
 * p.toString(): convert regular expression to String
 * 
 * Matcher could invoke toString(), group(), matches() 
 */
