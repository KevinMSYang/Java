public class StaticConstructor 
{
	private StaticConstructor(int w) // line 1
	{
		System.out.println(w);
	}
	public static StaticConstructor() // line 5
	{
		System.out.println(10);
	}
	public static void main(String[] args)
	{
		StaticConstructor obj = new StaticConstructor(50);
	}
}
/*Question: What is the expected output?
 * A: Wont compile because of line(1) - constructor cannot be private
 * B: 10 50
 * C: 50
 * D: Wont compile because of line(5) - constructor cannot be static
 *
 *ANS: D
 *Explanation:
 *A constructor cannot be marked as static in java
 *WHY: everything that is marked static belongs to the class only
 */
