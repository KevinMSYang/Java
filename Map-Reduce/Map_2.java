import java.util.*;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class Map_2 
{
	public static void main(String[] args) throws IOException
	{
		double[] ans_1 = new double[4];
		double[] ans_2 = new double[4];
		String inputfile = "splitfile_2.txt";
		String outputfile = "intermediate_2.txt";
		File file = new File(inputfile);
		Scanner inputData = new Scanner(file);
		PrintWriter outputData_1 = new PrintWriter(outputfile);
		int counter_month = 0;
		int partition = 744;
		int partition_2 = 720;
		int loop = 1;
		int min = 0;
		int max = 0;
		int sum = 0;
		int count_yes = 0;
		int sum_2 = 0;
		int loop_2 = 1;
		int min_2 = 0;
		int max_2 = 0;
		int count_yes_2 = 0;
		
		while (inputData.hasNextLine())
		{
			String str = inputData.nextLine();
			String station, date, temperature, precip;
			Scanner key = new Scanner(str);
			inputData.useDelimiter(" ");
			station = key.next();
			date = key.next();
			temperature = key.next();
			precip = key.next();
			counter_month++;
			
			if (counter_month <= partition)
			{
				sum += Integer.parseInt(temperature);
				if (loop == 1)
				{
					min = Integer.parseInt(temperature);
					ans_1[0] = min;
					max = Integer.parseInt(temperature);
					ans_1[1] = max;
					loop++;
				}
				if (ans_1[0] >= Integer.parseInt(temperature))
				{
					ans_1[0] = Integer.parseInt(temperature);
				}
				if (ans_1[1] <= Integer.parseInt(temperature))
				{
					ans_1[1] = Integer.parseInt(temperature);
				}
				
				if (precip.equals("YES"))
				{
					count_yes++;
				}
			}
			if (counter_month > partition)
			{
				sum_2 += Integer.parseInt(temperature);
				if (loop_2 == 1)
				{
					min_2 = Integer.parseInt(temperature);
					ans_2[0] = min_2;
					max = Integer.parseInt(temperature);
					ans_2[1] = max_2;
					loop_2++;
				}
				if (ans_2[0] >= Integer.parseInt(temperature))
				{
					ans_2[0] = Integer.parseInt(temperature);
				}
				if (ans_2[1] <= Integer.parseInt(temperature))
				{
					ans_2[1] = Integer.parseInt(temperature);
				}
				
				if (precip.equals("YES"))
				{
					count_yes_2++;
				}
			}
		}
		ans_1[2] = sum / partition;
		ans_1[3] = count_yes;
		ans_2[2] = sum_2 / partition_2;
		ans_2[3] = count_yes_2;
		for (int i = 0; i < ans_1.length; i++)
		{
			outputData_1.printf(ans_1[i] + " ");
		}
		outputData_1.println();
		outputData_1.flush();
		for (int i = 0; i < ans_2.length; i++)
		{
			outputData_1.printf(ans_2[i] + " ");
		}
		outputData_1.flush();
		
		// test print out
		for (int i = 0; i < ans_1.length; i++)
		{
			System.out.print(ans_1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < ans_2.length; i++)
		{
			System.out.print(ans_2[i] + " ");
		}
		
	}
}
