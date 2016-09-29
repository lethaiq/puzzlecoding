package MoodyAnalytics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LearningFromThePast {
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		int numDays;
		int[][] profits;
		
		//read problem input
//		System.out.println("Input:");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		numDays = Integer.parseInt(in.readLine());
		profits = new int[numDays][3];
		long maxProfit = 0;
		for (int i = 0; i < numDays; i++)
		{
			StringTokenizer st = new StringTokenizer(in.readLine());
			profits[i][0] = Integer.parseInt(st.nextToken());
			profits[i][1] = Integer.parseInt(st.nextToken());
			profits[i][2] = Integer.parseInt(st.nextToken());
			long dayMaxProfit = getMaximum(profits[i]);
			if (dayMaxProfit > maxProfit) maxProfit = dayMaxProfit;
		}
		System.out.println(maxProfit);
//		for (int[] dayProfit : profits)
//			System.out.println(Arrays.toString(dayProfit));
	}
	
	private static long getMaximum(int[] dayProfit)
	{
		Arrays.sort(dayProfit);
		return dayProfit[1] + dayProfit[2];
	}
	
	
}
