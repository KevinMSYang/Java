
public class StringBufferComparison 
{
	public static void main(String[] args)
	{
		StringBuffer buffer1 = new StringBuffer("javachamp");
		StringBuffer buffer2 = new StringBuffer(buffer1);
		String str = buffer1.toString();
		
		if (str.equals(buffer2))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
	}
}
/*Question: What is the result of compiling and running the following code? 
 * A: true
 * B: false
 * 
 * ANS: B
 * Explanation: equals() belongs String class
 * When an object of string is passed, the strings are compared. But when object of 
 * StringBuffer is passed references are compared because StringBuffer does not override
 * equals method of object class.
 * 
 * Hence only String.equals(String) can be true
 * others false, no matter StringBuffer.equals(String), String.equals(StringBuffer)
 * 
 */
