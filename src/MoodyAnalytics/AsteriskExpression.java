package MoodyAnalytics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AsteriskExpression {
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int numExp = Integer.parseInt(in.readLine());
		for(int i = 0; i < numExp; i++)
		{
			String expression = in.readLine();
			long val = eval(expression);
			if(val != 0) System.out.println(val);
			else System.out.println("Syntax Error");
		}
	}
	
	private static long eval(String e)
	{
		
		return 0;
	}
}
