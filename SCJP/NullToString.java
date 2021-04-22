
public class NullToString 
{
	public static void main(String[] args)
	{
		String s1 = null;
		String s2 = null;
		
		if (s1 == s2)
		{
			System.out.print("A");
		}
		if (s1.equals(s2))
		{
			System.out.print("B");
		}
	}
}

/*Question: What is the result of compiling and running the following code?
 *A: "AB" will be printed
 *B: "A" will be printed followed be a NullPointerException thrown
 *C: "B" will be printed
 *D: No output is produced
 *
 *ANS: B
 *Explanation: == operator compare reference location. Hence both String variables are 
 *point to the same memory location Null
 *But  .equals() used to compare the content.
 *The NullPointerExcption occurs when you declare a variable but did not create an object and 
 *assign it to the variable before trying to use the contents of the variable
 */
 