/**
 * @ File: Prog01tpmm.java
 * @ Brief: 1/ System setup:
 * 				a. Memory size for data: M records (Mem[M]) where M is a constant greater than or equal to 4
 * 				b. B records/block, where B is a constant greater than or equal to 2
 * 				c. A big sized hard disk (HD[8192])
 * 				d. HD[0] is save for an integer to indicate the number of records initially
 *          2/ Read from the given input file, and put into HD starting at HD[1]. After completed, put the total record number at HD[0]
 *          3/ Use 2PMM to sort the data in Mem and then move to/from HD
 *          4/ Please indicate where is your final results in the HD
 *          5/ Please describe your work clearly to sort the data
 *          6/ Please use the HW02 as an example and output print out same as HW01
 * @ Remarks
 *     Course: CS 6543
 *     Assignment#: prog01
 *     Due Date: 02.20.2018
 *     Instructor: Hung-Chi Su
 * @ Author: Kevin Yang
 * @ Date: 02.19.2018
 */

import java.util.*;

public class Prog01tpmm 
{
	public static void main(String[] args)
	{
		final int MEMORYSIZE = 8;									// declare a constant for memory size
		final int RECORDS = 24;										// declare a constant for how many records
		final int FIXBLOCK = 4;										// fix the size of 3 input memory and 1 output memory buffer
		int[] HD = new int[8192];									// create an array for HD
		int[] Mem = new int[MEMORYSIZE];								// create an array for Memory
		
		Random rand = new Random();									
		
		HD[0] = RECORDS;												// HD[0] indicate the number of records
		// generate some random numbers and store them into HD array
		for (int i = 1; i < RECORDS+1; i++)
		{
			HD[i] = rand.nextInt(50) +1;
		}
		
		//===================================================	 PHASE ONE ===================================================//	
		
		// print out the original data
		System.out.println("Original Data: ");
		for (int i = 0; i < RECORDS+1; i++)
		{
			System.out.print(HD[i] + " ");
		}
		System.out.println();
		
		int sublist = RECORDS / MEMORYSIZE;							// declare a variable which represent how many sub-list we have
		int count = 0;												// a counter that keep tracking our current sublist
		int start = 1;												// a starting index from HD array
		int store = RECORDS + 1;										// a starting index when the sorted sublist store data back to HD array
		
		// read data from HD array to Mem array, and sort the data. After that, store the data back to HD array
		while ( count < sublist)
		{
			for (int i = start , j = 0; j < MEMORYSIZE; i++, j++)		// i represent the HD starting index and j represent Mem starting index
			{
				Mem[j] = HD[i];
			}
			Arrays.sort(Mem);										// use sort function to sort data
			for (int i = 0, j = store; i < MEMORYSIZE; i++, j++)		// i represent the Mem starting index and j represent HD starting index
			{														// where we need to store the data from
				HD[j] = Mem[i];
			}
			++count;													// accumulator for sub-list counter
			start = (MEMORYSIZE * count) + 1;						// re-declare the number of starting index for HD array (input data from HD)
			store = RECORDS + (MEMORYSIZE * count) + 1;				// re-declare the number of starting index for HD array (input data from Mem)
		}
	
		// print out the phase 1 result
		System.out.println("\nPhase 1 Data: ");
		for (int i = 0; i < RECORDS + (MEMORYSIZE*sublist) + 1; i++)
		{
			System.out.print(HD[i] + " ");
		}
		
		//===================================================	 PHASE TWO ===================================================//	
		
		int block = MEMORYSIZE / FIXBLOCK;							// declare how many blocks for each input and output memory buffer
		
		// count the total outputIO for the terminal point of while loop
		int outputIO = RECORDS;
		if (outputIO % block != 0)
		{
			outputIO = RECORDS / block +1;
		}
		else
		{
			outputIO = RECORDS / block;
		}
		
		int counter = 0;												// a counter for tracking how many output IO we have
		int[] sublistarray = new int[sublist*2];						// declare an array to store the pointer for HD
		// even index represent the starting location of each sublist
		for (int i = 0, j = 0; i < sublistarray.length; i+=2, j++)
		{
			sublistarray[i] = RECORDS + (MEMORYSIZE * j) +1;
		}
		// odd index represent the ending location of that sublist
		for (int i = 1; i < sublistarray.length; i+=2)
		{
			sublistarray[i] = sublistarray[i-1] + MEMORYSIZE;
		}
		
		int result = RECORDS+(MEMORYSIZE*sublist)+1;					// a starting index when we finish phase 2 
		int memindex = 0;											// a variable represent the index of memory
		// store the first block from each sublist into memory array
		for ( int i = 0, y = 0; i < sublist; i++, y+=2)
		{
			for ( int j = 0, k = sublistarray[y]; j < block; memindex++, j++, k++)
			{
				Mem[memindex] = HD[k];
			}
		}
		
		int[] countarray = new int[FIXBLOCK];						// declare an array to store the pointer of each block
		// each index's number represent the initial number of the index
		for (int i = 0; i < countarray.length; i++)
		{
			countarray[i] = block * i;
		}
	
		// a loop for total times of output data from Mem to HD array
		while (counter < outputIO)
		{
			// a loop for each sub-list with comparison the min number and store two min numbers to HD array when violate the condition
			while ( countarray[countarray.length-1] < MEMORYSIZE)		// if the countarray[3] is greater or equal to the memorysize then terminated
			{
				// compare each index's value 
				if ( Mem[countarray[0]] <= Mem[countarray[1]] && Mem[countarray[0]] <= Mem[countarray[2]])
				{
					// move the lowest value into output memory block
					Mem[countarray[countarray.length-1]] = Mem[countarray[0]];
					// pointers increase one to keep tracking the current location
					countarray[0]++;
					sublistarray[0]++;
					countarray[countarray.length-1]++;
				}
				// compare each index's value
				else if (Mem[countarray[1]] <= Mem[countarray[0]] && Mem[countarray[1]] <= Mem[countarray[2]])
				{
					// move the lowest value into output memory block
					Mem[countarray[countarray.length-1]] = Mem[countarray[1]];
					// pointers increase one to keep tracking the current location
					countarray[1]++;
					sublistarray[2]++;
					countarray[countarray.length-1]++;
				}
				// compare each index's value
				else if (Mem[countarray[2]] <= Mem[countarray[0]] && Mem[countarray[2]] <= Mem[countarray[1]])
				{
					// move the lowest value into output memory block
					Mem[countarray[countarray.length-1]] = Mem[countarray[2]];
					// pointers increase one to keep tracking the current location
					countarray[2]++;
					sublistarray[4]++;
					countarray[countarray.length-1]++;
				}
				// if the first block is full, and also the pointer of HD is less than the ending location
				if ( countarray[0] == block && sublistarray[0] < sublistarray[1])									
				{
					for (int i = 0, j = sublistarray[0]; i < block; i++, j++)
					{
						Mem[i] = HD[j];
					}
					countarray[0] = 0;													// re-set the pointer accumulator for first block
				}
				// if the first block is full, and also it reach the ending point
				else if ( countarray[0] == block && sublistarray[0] >= sublistarray[1])
				{
					// insert the max number of integer to the memory index
					for (int i = 0; i < block; i++)
					{
						Mem[i] = Integer.MAX_VALUE;
					}
				}
				// if the second block is full, and also the pointer of HD is less than the ending location
				if ( countarray[1] == (block*2) && sublistarray[2] < sublistarray[3])									
				{
					for (int i = block, j = sublistarray[2]; i < (block*2); i++, j++)
					{
						Mem[i] = HD[j];
					}
					countarray[1] = block;												// re-set the pointer accumulator for second blank
				}
				// if the second block is full, and also it reach the ending point
				else if ( countarray[1] == (block*2) && sublistarray[2] >= sublistarray[3])
				{
					// insert the max number of integer to the memory index
					for (int i = block; i < (block*2); i++)
					{
						Mem[i] = Integer.MAX_VALUE;
					}
				}
				// if the third block is full, and also the pointer of HD is less than the ending location
				if ( countarray[2] == (block*3) && sublistarray[4] < sublistarray[5])								
				{
					for (int i = (block*2), j = sublistarray[4]; i < (block*3); i++, j++)
					{
						Mem[i] = HD[j];
					}
					countarray[2] = (block*2);											// re-set the pointer accumulator for third blank
				}
				// if the third block is full, and also it reach the ending point
				else if ( countarray[2] == (block*3) && sublistarray[4] >= sublistarray[5])
				{
					// insert the max number of integer to the memory index
					for (int i = (block*2); i < (block*3); i++)
					{
						Mem[i] = Integer.MAX_VALUE;
					}
				}
				
			}
			// store the data back to HD array from output Mem 
			for ( int i = (block*3), j = result; i < MEMORYSIZE; i++, j++)
			{
				HD[j] = Mem[i];
			}
			// pointers update
			countarray[countarray.length-1] = block*3;																
			result +=block;																
			counter++;	
		}
		
		// print out the phase two result
		System.out.println();
		System.out.println("\nPhase 2 Data: ");
		for (int i = 0; i < (RECORDS*2) + (MEMORYSIZE*sublist) + 1; i++)
		{
			System.out.print(HD[i] + " ");
		}
	}
}
