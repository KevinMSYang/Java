
public class StringAndStringBuffer_1 
{
	public static void main(String[] args)
	{
		StringBuffer sb1 = new StringBuffer("javachamp");
		StringBuffer sb2 = new StringBuffer("javachamp:");
		
		boolean stmt1 = sb1.equals(sb2);
		boolean stmt2 = sb1 == sb2;
		
		String s1 = new String("javachamp");
		String s2 = new String("javachamp");
		
		boolean stmt3 = s1.equals(s2);
		boolean stmt4 = s1 == s2;
		
	}
}
/*Question: Which of the statements will evaluate to true?
 * A: stmt1
 * B: stmt2
 * C: stmt3
 * D: stmt4
 * 
 * ANS: C
 * Explanation: We can use == operators for reference comparison(address comparison) and
 * .equals() method for content comparison. In simple words, == checks if both objects point to the 
 * same memory location whereas .equals() evaluates to the comparison of values in the objects.
 * If a class does not override the equals method, then by default it uses equals(Object o) method
 * of the closest parent class that has overridden this method
 * 
 */
