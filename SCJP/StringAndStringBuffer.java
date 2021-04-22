import java.util.*;

public class StringAndStringBuffer 
{
	public static void main(String[] args)
	{
		String str = "abc";
		StringBuffer strbf = new StringBuffer(str);
		
		String s = str.toString();
		String ss = strbf.toString();
		
		int i = str.length();
		int j = strbf.length();
		
		boolean k = str.equals(strbf);
		boolean q = strbf.equals(str);
		
		strbf.append("abc");
		
		String n = str.trim();
	}
}

/*Question: Select the common methods, which are defined for both type String and type StringBuffer
 * A: toString()
 * B: length()
 * C: append(String)
 * D: trim()
 * E: equals(object)
 * 
 * ANS: A,B,E
 * Explanation: only append, and trim can be both. 
 * trim means truncate first and last white space for given string
 */
