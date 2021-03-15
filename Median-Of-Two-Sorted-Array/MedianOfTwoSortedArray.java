import java.util.*;

public class MedianOfTwoSortedArray 
{
	/*Given two sorted arrays nums1 and nums2 of size m and n respectively
	 * return the median of the two sorted arrays
	 */
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String a = "";
		System.out.print("nums1 = ");
		a = keyboard.nextLine();
		String[] str1 = new String[a.length()]; 
		str1 = a.split(",");
		String b = "";
		System.out.print("nums2 = ");
		b = keyboard.nextLine();
		String[] str2 = new String[b.length()];
		str2 = b.split(",");
		
		if (a.isEmpty() || b.isEmpty())
		{
			int[] nums1 = new int[str1.length];
			if( a.isEmpty())
			{
				nums1 = storeValue(str2);
				nums1 = sortArray(nums1);
				findMedian(nums1);
			}
			else
			{
				nums1 = storeValue(str1);
				nums1 = sortArray(nums1);
				findMedian(nums1);
			}
		}
		else
		{
			int[] nums1 = new int[str1.length];
			int[] nums2 = new int[str2.length];
			nums1 = storeValue(str1);
			nums2 = storeValue(str2);
			int[] array = new int[str1.length + str2.length];
			array = mergeArray(nums1, nums2);
			array = sortArray(array);
			findMedian(array);
		}
	}
	public static int[] mergeArray(int[] arr1, int[] arr2)
	{
		int arr_size = arr1.length + arr2.length;
		int[] array = new int[arr_size];
		
		int k = 0;
		for (int i = 0; i < array.length; i++)
		{
			if (i >= arr1.length)
			{
				array[i] = arr2[k];
				k++;
			}
			else
			{
				array[i] = arr1[i];
			}
		}
		return array;
	}
	public static int[] sortArray(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 1; j < array.length; j++)
			{
				if (array[j-1]> array[j])
				{
					int temp;
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
	public static int[] storeValue(String[] str)
	{
		int[] array = new int[str.length];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = Integer.parseInt(str[i]);
		}
		return array;
	}
	public static void findMedian(int[] array)
	{
		double numbers;
		double median = (double)array.length / 2;
		if (median % 2 == 0)
		{
			numbers = (double)(array[(int)median]+array[(int)median-1]) /2;
			System.out.println("median = " +numbers);
		}
		else if(median == 1)
		{
			numbers = (double)(array[(int)median]+array[(int)median-1]) /2;
			System.out.println("median = "+numbers);
		}
		else
		{
			System.out.println("median = "+array[(int)median]);
		}
	}
}
