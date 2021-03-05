import java.io.File;
import java.io.IOException;
import java.util.*;
import java.lang.Math.*;

public class NaiveBayes 
{
	public static void main(String[] args)
	{
		
		// read file and below start to separate dataset into traning and testing set
		File file = new File("lymphography.csv");
		Scanner sc = null;
		
		int training[][] = new int[116][19];
		int testing[][] = new int[40][19];
		
		int row = 0;
		int col = 0;
		int row_1 = 0;
		int col_1 = 0;
		int row_2 = 0;
		int col_2 = 0;
		int count = 0;
		
		try
		{
			sc = new Scanner(file);
			while (sc.hasNext())
			{
				sc.useDelimiter(",|\\n");
				String data = sc.next();
				//ignore class label
				if (count < 19)
				{
					count++;
				}
				else
				{
					// first 30th row will be assigned to testing set
					if (row < 30)
					{
						testing[row_1][col_1] = Integer.parseInt(data);
						col_1++;
						if (col_1 == 19)
						{
							row_1++;
							col_1 = 0;
						}
					}
					// remaining data set will be store into training set
					else
					{
						training[row_2][col_2] = Integer.parseInt(data);
						col_2++;
						if (col_2 == 19)
						{
							row_2++;
							col_2 = 0;
						}
					}
					col++;
					if (col == 19)
					{
						row++;
						col = 0;
					}
				}
			}
			
		}
		catch (IOException exp)
		{
			exp.printStackTrace();
		}
		sc.close();
		// done: separate data set into training and testing
	
		
		double correct = 0.0;			// the number of if our model predict correctly
		double incorrect = 0.0;			// the number of if our model predict incorrectly
		
		double class_2 = 0;
		double class_3 = 0;
		double class_4 = 0;
		// count the total number of each class label
		for (int i = 0; i < 116; i++)
		{
			if (training[i][0] == 2)
			{
				class_2++;
			}
			else if (training[i][0] == 3)
			{
				class_3++;
			}
			else
			{
				class_4++;
			}
		}

		// the probability of each row that assign to each class label
		double prob_2 = 0.0;
		double prob_3 = 0.0;
		double prob_4 = 0.0;
		
		// we have 30 rows data in testing set, every iteration we will get the probability of each class label
		for (int i = 0; i < 30; i++)
		{
			// we have 3 class label, each iteration we pass different class label in order to comparison
			for (int j = 0; j < 3; j++)
			{
				double class_count = 0;
				int class_label = 0;
				if ( j == 0)
				{
					class_count = class_2;
					class_label = 2;
				}
				else if (j == 1)
				{
					class_count = class_3;
					class_label = 3;
				}
				else
				{
					class_count = class_4;
					class_label = 4;
				}
				// pass different class label into function, and class_count is equal to the total number of that class label
				double prob_tmp = classifier(training, testing, class_count, class_label, i);
				
				// calculate each class label's probability
				if (class_label == 2)
				{
					prob_2 = prob_tmp * (class_2 / 116);
				}
				else if (class_label == 3)
				{
					prob_3 = prob_tmp * (class_3 / 116);
				}
				else
				{
					prob_4 = prob_tmp * (class_4 / 116);
				}
				// consider the biggest number to the class label for that row
				if ( prob_2 > prob_3 && prob_2 > prob_4)
				{
					// compare the predict class label to the testing set, if correct then correct variable increment one and vice versa
					if (testing[i][0] == 2)
					{
						correct++;
					}
					else
					{
						incorrect++;
					}
				}
				if ( prob_3 > prob_2 && prob_3 > prob_4)
				{
					if (testing[i][0] == 3)
					{
						correct++;
					}
					else
					{
						incorrect++;
					}
				}
				if ( prob_4 > prob_3 && prob_4 > prob_2)
				{
					if (testing[i][0] == 4)
					{
						correct++;
					}
					else
					{
						incorrect++;
					}
				}	
			}
		}
		System.out.format("\nOverALL Accuracy: %f" , (correct/ (correct + incorrect)) * 100);
	}
	
	// function calculate the probability for each row with given condition
	public static double classifier(int[][] training, int[][] testing, double class_count, int class_label, int row)
	{
		double answer = 1.0;
		double counter = 0;
		// we have 19 columns attribute that need to comparing
		for (int k = 1; k < 19; k++)
		{
			// we have 116 rows training set that need to comparing
			for (int i = 0; i < 116; i++)
			{
				// restrict the class label and the location of testing set
				if (training[i][0] == class_label && training[i][k] == testing[row][k])
				{
					counter++;
				}
			}
			answer = answer * (counter / class_count);
			counter = 0;
		}
		// return the probability of P(A1,A2...An|C) but have not multiply P(C) yet
		return answer;
	}
}
