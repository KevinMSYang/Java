import java.io.File;
import java.io.IOException;
import java.util.*;
import java.lang.Math.*;


public class HomeWork03 
{
	public static void main(String[] args)
	{
		File file = new File("wine_data.csv");
		Scanner sc = null;
		
		double training[][] = new double[142][14];
		double testing[][] = new double[36][14];
		String table_name[] = new String[] {"Class", "Alcohol", "Malic acid", "Ash", "Alcalinity of ash", "Magnesium", "Total phenols", "Flavanoids", "Nonflavanoid phenols", "Proanthocyanins", "Color intensity", "Hue", "OD280/OD315 of diluted wines", "Proline"};
		
		//counter for split data into train and test 
		int col = 0;
		int row = 0;
		int tmp = 0;
		int tmp_1 = 0;
		// read file and split it into training and testing
		//=====================================================
		try
		{
			sc = new Scanner(file);
			while (sc.hasNext())
			{
				sc.useDelimiter(",|\\n");
				String data = sc.next();
				if (col % 5 == 0)
				{
					testing[tmp][row] = Double.parseDouble(data);
					if (row == 13)
					{
						tmp++;
					}
				}
				else
				{
					training[tmp_1][row] = Double.parseDouble(data);
					if (row == 13)
					{
						tmp_1++;
					}
				} 
				row++;
				if (row == 14)
				{
					col++;
					row =0;
				}
			}
		}
		catch (IOException exp)
		{
			exp.printStackTrace();
		}
		sc.close();
		//=====================================================
		System.out.println("Training set:");
		printresult(training, 142, 14);
		System.out.println("\n\nValidation set:");
		printresult(testing, 36, 14);
		
		//calculate each attribute's gini -- first layer
		
		for (int i = 1; i < 14; i++)
		{
			System.out.println("\n\n"+table_name[i]+ ":");
			get_gini(training, 142, i);
		}
	}
	
	public static void printresult(double[][] array, int col, int row)
	{
		for (int i = 0; i < col; i++)
		{
			System.out.println();
			for (int j = 0; j < row; j++)
			{
				System.out.print(array[i][j]+ " ");
			}
		}
	}
	
	public static void get_gini(double[][] array, int col, int row)
	{
		// parent gini
		double gini = 0;
		double class_1 = 0;
		double class_2 = 0;
		double class_3 = 0;
		double total = 0;
		
		for (int i = 0, j = 0; i < col; i++)
		{
			if (array[i][j] == 1)
			{
				class_1++;
			}
			else if (array[i][j] == 2)
			{
				class_2++;
			}
			else
			{
				class_3++;
			}
		}
		total = class_1 + class_2 + class_3;
		double sum1 =class_1/total;
		double sum2 = class_2/total;
		double sum3 = class_3/total;
		double sum4 = 0;
		double parent_gini = 1 - Math.pow(sum1, 2) - Math.pow(sum2, 2) - Math.pow(sum3, 2);
		
		System.out.println("parent Gini = " + parent_gini);
		
		// calculate gini for every split
		double split1_23 = 0;
		double split23_1 = 0;
		double n2_split1_23 = 0;
		double n2_split23_1 = 0;
		double midpoint = array[(col)/2][row];
		//split 1-2.3
		for (int i = 0, j = row; i < col; i++)
		{
			if (array[i][j] < midpoint && array[i][0] == 1)
			{
				split1_23++;
			}
			if (array[i][j] < midpoint && (array[i][0] == 2 || array[i][0] == 3))
			{
				split23_1++;
			}
		}
		for (int i = 0, j = row; i < col; i++)
		{
			if (array[i][j] >= midpoint && array[i][0] == 1)
			{
				n2_split1_23++;
			}
			if (array[i][j] >= midpoint && (array[i][0] == 2 || array[i][0] == 3))
			{
				n2_split23_1++;
			}
		}
		System.out.println("N1:class 1: " + split1_23 + "  N2:class1: " + n2_split1_23);
		System.out.println("N1:class 23: " + split23_1+ "  N2:class23: "+ n2_split23_1);
		sum1 = split1_23/ col;
		sum2 = split23_1/ col;
		sum3 = n2_split1_23/col;
		sum4 = n2_split23_1/col;
		double gini_split1_23 = 1 - Math.pow(sum1, 2) - Math.pow(sum2, 2);
		double gini_n2_split1_23 = 1 - Math.pow(sum3, 2) - Math.pow(sum4, 2);
		double gini_child1_23 = class_1/total * gini_split1_23 + (class_2+class_3)/total * gini_n2_split1_23;
		System.out.println("Gini for 1/23: " +gini_child1_23);
		
		//split 2-1.3
		double split2_13 = 0;
		double split13_2 = 0;
		double n2_split2_13 = 0;
		double n2_split13_2 = 0;
		for (int i = 0, j = row; i < col; i++)
		{
			if (array[i][j] < midpoint && array[i][0] == 2)
			{
				split2_13++;
			}
			if (array[i][j] < midpoint && (array[i][0] == 1 || array[i][0] == 3))
			{
				split13_2++;
			}
		}
		for (int i = 0, j = row; i < col; i++)
		{
			if (array[i][j] >= midpoint && array[i][0] == 2)
			{
				n2_split2_13++;
			}
			if (array[i][j] >= midpoint && (array[i][0] == 1 || array[i][0] == 3))
			{
				n2_split13_2++;
			}
		}
		System.out.println("N1:class 2: " + split2_13 + "  N2:class2: " + n2_split2_13);
		System.out.println("N1:class 13: " + split13_2+ "  N2:class13: "+ n2_split13_2);
		sum1 = split2_13/ col;
		sum2 = split13_2/ col;
		sum3 = n2_split2_13/col;
		sum4 = n2_split13_2/col;
		double gini_split2_13 = 1 - Math.pow(sum1, 2) - Math.pow(sum2, 2);
		double gini_n2_split2_13 = 1 - Math.pow(sum3, 2) - Math.pow(sum4, 2);
		double gini_child2_13 = class_2/total * gini_split2_13 + (class_1+class_3)/total * gini_n2_split2_13;
		System.out.println("Gini for 2/13: " +gini_child2_13);
		
		//split3-12
		double split3_12 = 0;
		double split12_3 = 0;
		double n2_split3_12 = 0;
		double n2_split12_3 = 0;
		for (int i = 0, j = row; i < col; i++)
		{
			if (array[i][j] < midpoint && array[i][0] == 3)
			{
				split3_12++;
			}
			if (array[i][j] < midpoint && (array[i][0] == 1 || array[i][0] == 2))
			{
				split12_3++;
			}
		}
		for (int i = 0, j = row; i < col; i++)
		{
			if (array[i][j] >= midpoint && array[i][0] == 3)
			{
				n2_split3_12++;
			}
			if (array[i][j] >= midpoint && (array[i][0] == 1 || array[i][0] == 2))
			{
				n2_split12_3++;
			}
		}
		System.out.println("N1:class 3: " + split3_12 + "  N2:class3: " + n2_split3_12);
		System.out.println("N1:class 12: " + split12_3+ "  N2:class12: "+ n2_split12_3);
		sum1 = split3_12/ col;
		sum2 = split12_3/ col;
		sum3 = n2_split3_12/col;
		sum4 = n2_split12_3/col;
		double gini_split3_12 = 1 - Math.pow(sum1, 2) - Math.pow(sum2, 2);
		double gini_n2_split3_12 = 1 - Math.pow(sum3, 2) - Math.pow(sum4, 2);
		double gini_child3_12 = class_3/total * gini_split3_12 + (class_1+class_2)/total * gini_n2_split3_12;
		System.out.println("Gini for 3/12: " +gini_child3_12);
		
		if (Math.min(gini_child1_23, gini_child2_13) == gini_child1_23 && Math.min(gini_child1_23, gini_child3_12) == gini_child1_23)
		{
			double min = gini_child1_23;
			String way = "Best Split by 1 / 2,3";
			System.out.println(way + " and Gini = " + min);
		}
		else if (Math.min(gini_child1_23, gini_child2_13) == gini_child2_13 && Math.min(gini_child2_13, gini_child3_12) == gini_child2_13)
		{
			double min = gini_child2_13;
			String way = "Best Split by 2 / 1,3";
			System.out.println(way + " and Gini = " + min);
		}
		else
		{
			double min = gini_child3_12;
			String way = "Best Split by 3 / 1,2";
			System.out.println(way + " and Gini = " + min);
		}
	}
}
