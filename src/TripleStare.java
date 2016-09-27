import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.math.*;
import java.math.*;

/*
 * Problem 8.1 in Craking the coding interview
 * Using HashMap as memoization to opimize the recursion
 * @input: N = Number of test cases, follows by test cases separated by \n
 * @output: number of ways 
 */
public class TripleStare {
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		System.out.print("N=");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		for (int i=0; i<N; i++) 
		{
			int total_steps = Integer.parseInt(in.readLine());
			Map<Integer, BigInteger> memo = new HashMap<>();
			System.out.println(count_ways(total_steps+1, memo).toString());
		}
		
	}
	
	static BigInteger count_ways(int steps, Map<Integer, BigInteger> memo)
	{
		if (steps <= 2) return BigInteger.ONE;
		if (!memo.containsKey(steps))
		{
			BigInteger v = count_ways(steps -2, memo).add(count_ways(steps -1, memo));
			memo.put(steps, v);
		}
			
		return memo.get(steps);
	}
}
