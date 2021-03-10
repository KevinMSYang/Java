/**
 * @ File: Prog02.java
 * @ Brief: 1/ System setup:
 * 				a. B records/block (ie. bucket size plus 1 pointer. For example, B=5, the bucket can hold 4 records and 1 pointer), where B is a constant greater than or equal to 3.
 * 				b. HD[8192] to simulate a hard disk.
 * 				c. HD[0] is save for an integer to indicate the number of records initially.
 * 				d. UTILIZATION constant should be defined at beginning.
 * 				e. Read from the given input file, and put into HD starting at HD[1]. After completed, put the total record number at HD[0].
 *          2/ Linear Hashing:
 *          		a. Create a first bucket where keep the information about r, i, n, and point to the first bucket(index).
 *          		b. Read from HD, one after one to insert into the hashing bucket in the HD.
 *          		c. A data structure to maintain your available HD for overflowed blocks in needed.
 *          3/ After you finish insertion, prompt a message and get the data from user to search.
 * @ Remarks
 *     Course: CS 6543
 *     Assignment#: prog02
 *     Due Date: 04.05.2018
 *     Instructor: Hung-Chi Su
 * @ Author: Kevin Yang
 * @ Date: 04.05.2018
 */

import java.util.*;

public class Prog02 
{
	public static void main(String[] args) 
	{
		Random rand = new Random();
		Scanner keyboard = new Scanner(System.in);
		
		//=====================================SYSTEM SETUP=====================================//
		final int ARRAY_SIZE = 8192;															// constant: hard disk array size
		final int RECORD = 20;																// constant: the number of record will be hashing in linear
		final int BUCKET_SIZE = 5;															// constant: bucket size ( 4 records and 1 pointer)
		final int PRESET_SIZE = 1000;														// constant: preset size for overflow and other array size
		final int RAND_NUM = 15;
		
		int[] HD = new int[ARRAY_SIZE];														// declare an HD array to store the hashing result
		int[] rand_data = new int[RECORD];													// declare an array to store random generated number as an input record
		int[] valid_hd = new int[PRESET_SIZE];												// declare an array to store the number of each bucket pointer 
		int[] valid_overflow = new int[PRESET_SIZE];											// declare an array to store the number of each overflow bucket pointer
		int[] cap_hd = new int[PRESET_SIZE];													// declare an array to store the number of each bucket pointer terminated point
		int[] cap_overflow = new int[PRESET_SIZE];											// declare an array to store the number of each overflow bucket pointer terminated point
		int[] original_hd = new int[PRESET_SIZE];											// declare an array to store initial bucket pointer for searching
		int[] original_overflow = new int[PRESET_SIZE];										// declare an array to store initial overflow bucket pointer for searching
		
		int indicate_bit = 1;																// variable: indicate_bit as 'i' in linear hashing 
		int node_num = 2;																	// variable: node_num as 'n'	in linear hashing
		int record_num = 0;																	// variable: record_num as 'r' in linear hashing
		
		
		HD[0] = RECORD;																		// HD[0] store how many records
		// Random generator 1 to RAND_NUM and insert into array
		for (int i = 0; i < rand_data.length; i++)
		{
			rand_data[i] = rand.nextInt(RAND_NUM) +1;
		}
		// Initialize 0 into HD array
		for (int i = 1; i < ARRAY_SIZE; i++)
		{
			HD[i] = 0;
		}
		// Initialize number in each array
		for (int i = 0; i < PRESET_SIZE; i++)
		{
			valid_hd[i] = 1 + (BUCKET_SIZE * i);												// pointer as HD bucket
			valid_overflow[i] = (ARRAY_SIZE - 1) - (BUCKET_SIZE * i);							// pointer as overflow bucket
			cap_hd[i] = BUCKET_SIZE * (i + 1);												// pointer as  HD bucket terminated point
			cap_overflow[i] = valid_overflow[i] - BUCKET_SIZE + 1;							// pointer as overflow bucket terminated point
			original_hd[i] = 1 + (BUCKET_SIZE * i);											// initial number of HD bucket
			original_overflow[i] = (ARRAY_SIZE - 1) - (BUCKET_SIZE * i);						// initial number of overflow bucket
		}
		
		//=====================================LINEAR HASHING=====================================//
		
		// this for loop is the peripheral loop as for assigning random number into HD array
		for (int i = 0; i < rand_data.length; i++)
		{
			// if buckets is full then add a new bucket
			if (record_num >= node_num * (BUCKET_SIZE-1))
			{
				node_num++;
				// if n > 2^i then i++
				if (node_num > Math.pow(2, indicate_bit))
				{
					indicate_bit++;
					//=====================================RE-ARRANGE BUCKET=====================================// 
					/* ALGORITH: 
					 * create a temporary array to store records that are already inside hashing bucket
					 * re-assign the value into pointer
					 * modulo the record again and store it back to the HD
					 */
					int[] temp_array = new int[record_num+1];								// record_num+1 is for avoiding HD[0]
					// store the record into temporary array
					for (int k = 1, q = 1; q < temp_array.length; k++, q++)
					{
						// store actual records 
						if (HD[k] != 0)
						{
							temp_array[q] = HD[k];
						}
						HD[k] = 0;															// re-assign default value 0 to HD
					}
					// re-assign initial number to each bucket pointer
					for (int k = 0; k < PRESET_SIZE; k++)
					{
						valid_hd[k] = original_hd[k];
						valid_overflow[k] = original_overflow[k];
					}
					// throw records back to HD array
					for (int j = 1; j < temp_array.length; j++)
					{
						int two_to_i = (int) Math.pow(2, indicate_bit);
						int assign_node = temp_array[j] % two_to_i;
						// when modulo 2^i decide which bucket to throw the record
						// if h(k)[i] < n then look at bucket h(k)[i] else look at bucket h(k)[i] - 2^i-1
						if (assign_node < node_num)
						{
							if (valid_hd[assign_node] >= cap_hd[assign_node])
							{
								HD[valid_overflow[assign_node]] = temp_array[j];
								valid_overflow[assign_node]--;
							}
							else 
							{
								HD[valid_hd[assign_node]] = temp_array[j];
								valid_hd[assign_node]++;
							}
						}
						else 
						{
							assign_node = (int) (temp_array[j] % Math.pow(2, indicate_bit-1));
							if (valid_hd[assign_node] >= cap_hd[assign_node])
							{
								HD[valid_overflow[assign_node]] = temp_array[j];
								valid_overflow[assign_node]--;
							}
							else
							{
								HD[valid_hd[assign_node]] = temp_array[j];
								valid_hd[assign_node]++;
							}
						}
					}
				}
			}
			int two_to_i = (int) Math.pow(2, indicate_bit);										// variable: store value 2^i
			int assign_node = rand_data[i] % two_to_i;											// variable: store value record % 2^i
			// when modulo 2^i decide which bucket to throw the record
			// if h(k)[i] < n then look at bucket h(k)[i] else look at bucket h(k)[i] - 2^i-1
			if (assign_node < node_num)
			{
				if (valid_hd[assign_node] >= cap_hd[assign_node])
				{
					HD[valid_overflow[assign_node]] = rand_data[i];
					valid_overflow[assign_node]--;
				}
				else 
				{
					HD[valid_hd[assign_node]] = rand_data[i];
					valid_hd[assign_node]++;
				}
			}
			else
			{
				assign_node = (int) (rand_data[i] % Math.pow(2, indicate_bit-1));
				if (valid_hd[assign_node] >= cap_hd[assign_node])
				{
					HD[valid_overflow[assign_node]] = rand_data[i];
					valid_overflow[assign_node]--;
				}
				else
				{
					HD[valid_hd[assign_node]] = rand_data[i];
					valid_hd[assign_node]++;
				}
			}
			record_num++;	
		}
		
		//=====================================OUTPUT SCREEN=====================================// 
		int count = 0;														// variable: accumulator that break the line
		int current_bucket = 0;												// variable: represent current bucket number
		System.out.println("Total Record: " + HD[0]);
		System.out.println("Linear Hashing output:");
		// print out linear hashing that begin from HD array
		for (int i = 1; i <= Math.pow(2, indicate_bit) * (BUCKET_SIZE); i++)
		{
			if (count == 0)
			{
				System.out.print("Bucket " + current_bucket + ": ");
			}
			System.out.print(HD[i] + ", ");
			count++;
			if(count == BUCKET_SIZE)
			{
				System.out.println();
				count = 0;
				current_bucket++;
			}
		}
		count = 0;															// re-assign value
		current_bucket = 0;													// re-assign value
		// print out overflow bucket
		System.out.println();
		System.out.println("======================================");
		System.out.println("Overflow Bucket output: ");
		for (int i = HD.length-1; i > (HD.length - 1) - Math.pow(2, indicate_bit) * (BUCKET_SIZE); i--)
		{
			if (count == 0)
			{
				System.out.print("Overflow bucket " + current_bucket + ": ");
			}
			System.out.print(HD[i] + ", ");
			count++;
			if (count == BUCKET_SIZE)
			{
				System.out.println();
				count = 0;
				current_bucket++;
			}
		}
		System.out.println();
		System.out.println("======================================");
		System.out.println();
		// print out searching
		System.out.print("Search a number inside the HD array: ");
		// modulo 2^i and search that bucket whether the record is inside or not
		int input_num = keyboard.nextInt();
		int assign_node = input_num % (int) Math.pow(2, indicate_bit);
		boolean return_ans = false;
		if (assign_node < node_num)
		{
			for (int j = 0; j < BUCKET_SIZE; j++)
			{
				if (HD[original_hd[assign_node]] == input_num)
				{
					return_ans = true;
				}
				else
				{
					original_hd[assign_node]++;
				}
				if (HD[original_overflow[assign_node]] == input_num)
				{
					return_ans = true;
				}
				else
				{
					original_overflow[assign_node]--;
				}
			}
		}
		else
		{
			assign_node = (int) (input_num % Math.pow(2, indicate_bit-1));
			for (int j = 0; j < BUCKET_SIZE; j++)
			{
				if (HD[original_hd[assign_node]] == input_num)
				{
					return_ans = true;
				}
				else
				{
					original_hd[assign_node]++;
				}
				if (HD[original_overflow[assign_node]] == input_num)
				{
					return_ans = true;
				}
				else
				{
					original_overflow[assign_node]--;
				}
			}
		}
	
		
		if (!return_ans)
		{
			System.out.println("NOT FOUND");
		}
		else
		{
			System.out.println("FOUND, this number is in the overflow bucket " + assign_node);
		}
		keyboard.close();
	}
}
