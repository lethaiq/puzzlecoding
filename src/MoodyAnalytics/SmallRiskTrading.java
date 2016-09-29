package MoodyAnalytics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SmallRiskTrading {
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//ask for input for local testing
		System.out.println("Input:");
		
		int n, k;
		double[] p, profit, loss;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		p = new double[n];
		profit = new double[n];
		loss = new double[n];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) p[i] = Double.parseDouble(st.nextToken());

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) profit[i] = Double.parseDouble(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) loss  [i] = Double.parseDouble(st.nextToken());
	
		PriorityQueue<Double> outcome = new PriorityQueue<Double>();
		for (int i = 0; i < n; i++)
		{
			double tradeValue = p[i] * (profit[i] + loss[i]) - loss[i];
			if (outcome.size() < k) outcome.add(tradeValue);
			else if (outcome.size() == k & tradeValue > outcome.peek())
			{
				outcome.poll();
				outcome.add(tradeValue);
			}
			
		}
		double max = 0;
//		System.out.println(outcome.size());
		for (double value : outcome) max += value > 0 ? value : 0;
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(df.format(max));
	}	
}
