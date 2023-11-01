
/* You are given an array of characters letters that is sorted in non-decreasing order
 * and a character target. There are at least two different characters in letters.
 * Return the smallest character in letters that is lexicographically greater than target.
 * If such a character does not exist, return the first character in letters.
 * 
 * Example:
 * Input: letters = [c, f, j] Target = a, Output: c
 * Input: letters = [c, f, j] Target = c, Output: f
 */
public class FindSimallestLetterGreaterThanTarget 
{
	public static void main(String args[])
	{
		char[] letters = {'x', 'x','y','y'};
		char target = 'z';
		System.out.println(nextGreatestLetter(letters, target));
		int a = 'c';
		int b = 'f';
		int c = 'j';
		System.out.println(a + "|" + b + "|" + c);
	}
	
	public static char nextGreatestLetter(char[] letters, char target)
	{
		int min = letters[0];
		int next = 0;
		for (int i = 1; i < letters.length; i++)
		{
			if (min <= target)
			{
				if (letters[i] > target)
				{
					min = letters[i];
					next++;
				}
			}
			else
			{
				if (letters[i] < min)
				{
					min = letters[i];
				}
			}
		}
		if (next != 0)
		{
			return (char) min;
		}
		else
		{
			return letters[0];
		}
		
	}
}
