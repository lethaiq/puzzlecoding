package MoodyAnalytics;
import java.math.BigDecimal;
import java.math.BigInteger;

public class ModularExponential {
	final static double MOD = 19;
	public static void main(String[] args)
	{
		BigInteger mod = BigInteger.ONE;
		mod = mod.multiply(BigInteger.valueOf(10));
		mod = mod.pow(9);
		mod = mod.add(BigInteger.valueOf(7));
		System.out.println(mod.toString());
		
		BigInteger a = BigInteger.valueOf(3215);
		int n = 11723;
		System.out.println(a.modPow(BigInteger.valueOf(n), mod));
//		System.out.println(calcPower(a,n));
	}
	
	public static double calcPower(double x, double n) throws IllegalArgumentException
	{	
		System.out.println(x + "^" + n);
		if (n == 1) return x;
		if (n == 0) return 1;
		if (n % 2 == 0) return calcPower(((x % MOD) * (x % MOD)) % MOD , n/2) % MOD;
		if (n % 2 != 0) return ((calcPower(((x % MOD) * (x % MOD)) % MOD, (n-1)/2) % MOD) * (x % MOD)) % MOD;
		return 0;
	}
	
	public static double calcPower2(double x, double n)
	{
		if (n == 1) return x;
		if (n == 0) return 1;
		double result = 1;
		for (int i =0; i<n; i++)
		{
			result = result * (x % MOD);
			result = result % MOD;
		}
		return result;
	}
}
