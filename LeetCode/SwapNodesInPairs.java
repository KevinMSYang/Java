import java.util.*;

import MergeTwoSortedLists.Node;

public class SwapNodesInPairs 
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
	
	SwapNodesInPairs swap(SwapNodesInPairs list)
	{
		Node current = head;
		Node pre = head;
		int count = 0;
		int temp;
		while (current != null)
		{
			if ( count%2 == 1)
			{
				temp = current.data;
				current.data = pre.data;
				pre.data = temp;
			}
			pre = current;
			current = current.next;
			count++;
		}
		return list;
	}
	
	void push(int new_data)
	{
		Node new_node = new Node(new_data);
		new_node.next = null;
		
		if (head == null)
		{
			head = new_node;
		}
		else
		{
			Node last = head;
			while (last.next != null)
			{
				last = last.next;
			}
			last.next = new_node;
		}
	}
	
	void print()
	{
		Node cur_node = head;
		int count = 0;
		while( cur_node != null)
		{
			cur_node = cur_node.next;
			count++;
		}
		Node cur = head;
		int temp = 0;
		while (cur != null)
		{
			if (temp == count -1)
			{
				System.out.print(cur.data);
			}
			else
			{
				System.out.print(cur.data + ",");
			}
			cur = cur.next;
			temp++;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		SwapNodesInPairs list = new SwapNodesInPairs();
		System.out.print("head = ");
		String head = keyboard.nextLine();
		head = head.replace(",", "");
		
		for (int i = 0 ; i < head.length(); i++)
		{
			int temp = Character.getNumericValue(head.charAt(i));
			list.push(temp);
		}
		list = list.swap(list);
		list.print();
		
	}
}
