import java.util.*;

public class GroupAnagrams 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("strs = ");
		String str = keyboard.nextLine();
		str = str.replace("[", "");
		str = str.replace("]", "");
		String[] temp = str.split(",");
		System.out.print(anagram(temp));
	}
	
	public static List<List<String>> anagram(String[] strs)
	{
		List<List<String>> res = new ArrayList<>();
		if(strs == null || strs.length == 0)
		{
			return res;
		}
		HashMap<String, Integer> map = new HashMap<>();
		for(String str: strs)
		{
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String s = new String(ch);
			if(map.containsKey(s))
			{
				List<String> list = res.get(map.get(s));
				list.add(str);
			}
			else
			{
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(s, res.size());
				res.add(list);
			}
		}
		return res;
	}
}
