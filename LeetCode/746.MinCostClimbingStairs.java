import java.util.*;

/* You are given an integer array cost where cost[i] is the cost of i^th step on a staircase
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1
 * Return the minimum cost to reach the top of the floor
 * Example cost[10,15,20]
 * Output: 15
 * 
 * Strategy:
 * Start from third index, compare the previous two index cost
 * Add on to the array. Make sure in order to reach this step, how much cost is required
 */

public class MinCostClimbingStairs 
{
	public static void main(String args[])
	{
		
	}
	public int minCostClimbingStairs(int[] cost)
	{
		int n = cost.length;
		for (int i = 2; i < n; i++)
		{
			cost[i] += Math.min(cost[i - 1], cost[i - 2]);
		}
		return Math.min(cost[n - 1], cost[n - 2]);
	}
}
