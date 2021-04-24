import java.util.LinkedList;
import java.util.*;

public class OO_RemoveNthNodeFromEndofList 
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
	void deleteNode(int key)
	{
		Node current = head;
		Node pre = head;
		int counter = 0;
		Node cur = head;
		while (current != null)
		{
			current = current.next;
			counter++;
		}
		int tmp = counter - key;
		if (tmp == 0)
		{
			head = cur.next;
		}
		else
		{
			counter = 0;
			while (cur != null)
			{
				if (counter == tmp)
				{
					pre.next = cur.next;
					break;
				}
				else
				{
					pre = cur;
					cur = cur.next;
					counter++;
				}
			}
		}
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
	
	void printList()
	{
		Node tnode = head;
		while(tnode != null)
		{
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
	}
	
	public static void main(String[] args)
	{
		OO_RemoveNthNodeFromEndofList llist = new OO_RemoveNthNodeFromEndofList();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("head = ");
		String head = keyboard.nextLine();
		head = head.replace(",", "");
		System.out.print("n = ");
		int n = keyboard.nextInt();
		for (int i = 0; i < head.length(); i++)
		{
			int temp = Character.getNumericValue(head.charAt(i));
			llist.push(temp);
		}
		llist.deleteNode(n);
		llist.printList();
	}
}
