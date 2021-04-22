
public class JavaObject 
{
	public static void main(String[] args)
	{
		boolean stmt1 = "champ" == "champ";
		boolean stmt2 = new String("champ").equals(new String("champ"));
		boolean stmt3 = "champ".toString() == "champ";
		
		System.out.println(stmt1);
		System.out.println(stmt2);
		System.out.println(stmt3);
		System.out.println(stmt1 && stmt2 && stmt3);
	}
}
/*Question: What is the expected output?
 * A:true
 * B:false
 * 
 * ANS: true
 * Explanation: stmt1, stmt2, and stmt3 all true
 * Check: ObjectComparison 
 */
 