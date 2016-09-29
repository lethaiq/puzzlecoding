package MoodyAnalytics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Stack;

public class AsteriskExpression {
	final static String MULTI = "*";
	final static String POWER = "**";
	public static void main(String[] args) throws IOException
	{
		BigInteger mod = BigInteger.ONE;
		mod = mod.multiply(BigInteger.valueOf(10));
		mod = mod.pow(9);
		mod = mod.add(BigInteger.valueOf(7));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input:");
		int numExp = Integer.parseInt(in.readLine());
		for(int i = 0; i < numExp; i++)
		{
			String expression = in.readLine();
			BigInteger val = eval(expression, mod);
			DecimalFormat df = new DecimalFormat("#.#");
//			System.out.println(val.toString());
			if(val.compareTo(BigInteger.valueOf(-1)) != 0) System.out.println(val.toString());
			else System.out.println("Syntax Error");
		}
	}
	
	private static BigInteger eval(String e, BigInteger MOD)
	{
		if (String.valueOf(e.charAt(0)).equals("*")) return BigInteger.valueOf(-1);
		if (String.valueOf(e.charAt(e.length()-1)).equals("*")) return BigInteger.valueOf(-1);
		Stack<BigInteger> num = new Stack<BigInteger>();
		String preNum = "";
		String preOpt = "";
		int i = 0;
		while (i < e.length())
		{
			String Char = String.valueOf(e.charAt(i));
//			System.out.println("Current=" + Char);
			if (Char.equals(MULTI))
			{
//				if char is an Asterisk
				if (!preNum.equals(""))
				{
//					System.out.println("PreNum=" + preNum);
//					System.out.println("PreOpt=" + preOpt);
					if (preOpt.equals(MULTI))
					{
						num.add(BigInteger.valueOf(Long.parseLong(preNum)).mod(MOD));
						preOpt = "";
					}
					else if (preOpt.equals(POWER))
					{
//						num.add(Math.pow(num.pop(), Double.parseDouble(preNum)));
//						num.add(calcPower(num.pop(), Double.parseDouble(preNum)));
						num.add(num.pop().modPow(BigInteger.valueOf(Long.parseLong(preNum)), MOD));
						preOpt = "";
					}
					else if (preOpt.equals("")) 
					{
						num.add(BigInteger.valueOf(Long.parseLong(preNum)).mod(MOD));
					}
					preNum = "";
				} else if (preOpt.equals(POWER)) return BigInteger.valueOf(-1);
//				System.out.println("Add " + MULTI + " to preOpt");
				preOpt = preOpt + MULTI;
			}
			else
			{
//				if char is an number
				if(preNum.equals("") && Char.equals("0")) return BigInteger.valueOf(-1);
//				if(!preNum.equals("") && Integer.parseInt(String.valueOf(preNum.charAt(preNum.length()-1))) > Integer.parseInt(Char)) return BigInteger.valueOf(-1);
				preNum = preNum + Char;
				if (i == e.length() - 1)
				{
//					if the number located at last
					e = e + MULTI;
				}
			}
			i = i + 1;
		}
		BigInteger result = BigInteger.ONE;
		while(!num.isEmpty())
		{
//			System.out.println(num.peek());
			result = result.multiply(num.pop());
		}
		return result.mod(MOD);
	}
}
