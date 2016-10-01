package MoodyAnalytics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;

public class PresidentialGala {

	static PriorityQueue<Integer> remains = new PriorityQueue<Integer>();
	public static void main(String[] args) throws IOException
	{
		int n;
		int m;
		int[] p;
		long sum = 0;
		long[] max;
		String arg[];
		
		System.out.println("Input:");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		arg = in.readLine().split(" ");
		n = Integer.parseInt(arg[0]);
		m = Integer.parseInt(arg[1]);
		p = new int[n];
		max = new long[n];
		long[] edgex = new long[n];
		int[][] edge = new int[n][n];
		int[][] decision = new int[n][n];
		arg = in.readLine().split(" ");
		for (int i=0; i<n; i++)
		{
			remains.add(i);
			sum += Integer.parseInt(arg[i]);
			p[i] = Integer.parseInt(arg[i]);
		}
		Arrays.fill(max, sum);
//		Arrays.fill(edgex, 11111);
//		System.out.println();
		for (int i=0; i<m; i++)
		{
			arg = in.readLine().split(" ");
			int edge1 = Integer.parseInt(arg[0]) - 1;
			int edge2 = Integer.parseInt(arg[1]) - 1;
			edge[edge1][edge2] = 1;
			edge[edge2][edge1] = 1;
//			System.out.println("Link between " + edge1 + " & " + edge2);
			edgex[edge1] = (long) (edgex[edge1] + Math.pow(10, n - edge2 - 1));
			edgex[edge2] = (long) (edgex[edge2] + Math.pow(10, n - edge1 - 1));
//			for (int j=0; j<n; j++) System.out.println(edgex[j]);
		}
//		for(int i=0; i<n; i++)
//			System.out.println(Arrays.toString(edge[i]));
		for (int j=0; j<n; j++)
		{

//			System.out.println(edgex[j]);
		}
			
			
//		System.out.println();
		long maxx = 0;
		while(!remains.isEmpty())
		{
			int i = remains.poll();
//			System.out.println("processing " + i);
			long vote = traverse(edgex, -1, i, p, edgex[i])-edgex[i];
			String str = String.valueOf(vote);
//			System.out.println(str);
			long result = 0;
			for(int q=n-1; q>=0;q--)
			{
//				System.out.println(q + " - " + str.length());
				int x = q - n + str.length();
//				System.out.println("Check " + x);
				if((n-q)<str.length()+1)
				{
					if( String.valueOf(str.charAt(x)).equals("0"))
					{
//						System.out.println("Adding city " + q);
						result = result + p[q];
					}
				}
				else
				{
//					System.out.println("Adding city " + q);
					result = result + p[q];
				}
			}
//			System.out.println(result);
			if (result > maxx) maxx = result;
		}
		System.out.println(maxx);
		

	}
	
	private static long traverse(long[] edgex, int start, int row, int[] p, long decision)
	{
		remains.remove(row);
		long result = decision;
//		System.out.print("Traverse: start=" + start + " row=" + row + " ");
		String str = String.valueOf(result);
		for (int i = 0; i<p.length-str.length();i++) str = "0" + str;
//		System.out.println("decision=" + str);
		
		for (int i=start+1; i<edgex.length; i++)
		{
			String curCar = String.valueOf(str.charAt(i));
//			System.out.println(curCar);
			if (curCar.equals("0")) 
			{
//				System.out.println("Found 0 at row=" + row + " col=" + i);
//				System.out.println("Summing " + decision + " + " + edgex[i]);
				result = result + edgex[i];
				return traverse(edgex, i, i, p, result);
			}
		}
//		System.out.println("Returning...");
		return result;
	}
	
}
