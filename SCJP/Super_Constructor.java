
public class Super_Constructor 
{
	Super_Constructor()
	{
		System.out.println("created");
	}
}
class Child extends Super_Constructor
{
	Child()
	{
		System.out.println("child created");
	}
}
public class Child
{
	public static void main(String[] args)
	{
		Child tree = new Child();
	}
}
/*Question: What is expected output?
 * A:created
 * 	child created
 * B: child created
 * 	created
 * C: RuntimeException
 * D: Compilation error
 * 
 * ANS: D
 * Explanation: Child is already defined
 */
 *