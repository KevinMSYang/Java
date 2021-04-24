import java.util.*;
import java.util.LinkedList;

public class MergeTwoSortedLists 
{
	Node head;
	
	class Node
	{
		int data;
		Node next;
		
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	MergeTwoSortedLists sortArray(MergeTwoSortedLists list)
	{
		Node current = list.head;
		Node pre = list.head;
		int tmp;
		while (pre != null)
		{
			current = pre.next;
			while (current != null)
			{
				if (pre.data > current.data)
				{
					tmp = pre.data;
					pre.data = current.data;
					current.data = tmp;
				}
				current = current.next;
			}
			pre = pre.next;
		}
		
		
		return list;
	}
	static MergeTwoSortedLists merge(MergeTwoSortedLists list1, MergeTwoSortedLists list2, MergeTwoSortedLists arr)
	{
		Node l1 = list1.head;
		Node l2 = list2.head;
		
		while (l1 != null)
		{
			arr.push(arr, l1.data);
			l1 = l1.next;
		}
		while (l2 != null)
		{
			arr.push(arr, l2.data);
			l2 = l2.next;
		}
		return arr;
	}
	
	MergeTwoSortedLists push(MergeTwoSortedLists list, int new_data)
	{
		Node new_node = new Node(new_data);
		new_node.next = null;
		
		if (list.head == null)
		{
			list.head = new_node;
		}
		else
		{
			Node last = list.head;
			while (last.next != null)
			{
				last = last.next;
			}
			last.next = new_node;
		}
		return list;
	}
	
	void print()
	{
		Node cur_node = head;
		while( cur_node != null)
		{
			System.out.print(cur_node.data + ",");
			cur_node = cur_node.next;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		MergeTwoSortedLists list1 = new MergeTwoSortedLists();
		MergeTwoSortedLists list2 = new MergeTwoSortedLists();
		MergeTwoSortedLists arr = new MergeTwoSortedLists();
		
		System.out.print("l1 = ");
		String l1 = keyboard.nextLine();
		list1 = insert(list1, l1);
		System.out.print("l2 = ");
		String l2 = keyboard.nextLine();
		list2 = insert(list2, l2);
		list1 = list1.sortArray(list1);
		list2 = list2.sortArray(list2);
		arr = merge(list1, list2, arr);
		arr = arr.sortArray(arr);
		arr.print();
		
		
	}
	static MergeTwoSortedLists insert(MergeTwoSortedLists list, String str)
	{
		str = str.replace(",", "");
		for (int i = 0; i < str.length(); i++)
		{
			int temp = Character.getNumericValue(str.charAt(i));
			list = list.push(list, temp);
		}
		return list;
	}
}
