import java.math.BigInteger;

public class Project1_PNizi 
{

	public static void main(String[] args) 
	{
		//primeFactorization
		long x=315L;
		System.out.println(primeFactorization(x));
	}
	public static String primeFactorization(long n)
	{
		long startTime = System.currentTimeMillis();
		StringBuilder sb=new StringBuilder();
		sb.append(n+"=");
		int count=0;
		//# of 2s that divide into n
		while(n%2==0)
		{
			count++;
			n=n/2;
		}
		if(count!=0)
		{
			sb.append("("+2+"^"+count+")");
		}
		
		// n must be odd so we can skip evens 
		for(long i=3;i<=Math.sqrt(n);i=i+2)
		{
			count=0;
			while(n%i==0)
			{
				n /=i;
				count++;
			}
			if(count!=0)
				sb.append("("+i+"^"+count+")");
		}
		//if n is a prime number > 2
		if(n>2)
			sb.append("("+n+"^"+1+")");
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
		return sb.toString();
	}
	/*
	 * about 50% less efficient
	 *
	public static String primeFactorization2(long n)
	{
		long startTime = System.currentTimeMillis();
		StringBuilder sb=new StringBuilder();
		sb.append(n+"=");
		int count=0;
		for(long i=2;i<=Math.sqrt(n);i++)
		{
			count=0;
			while(n%i==0)
			{
				n /=i;
				count++;
			}
			if(count!=0)
				sb.append("("+i+"^"+count+")");
		}
		//if n is a prime number > 2
		if(n>2)
			sb.append("("+n+"^"+1+")");
		
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
		return sb.toString();
	}
	*/
	public static long extendedEuclidGCD(long a, long b, long [] xy)
	{
		StringBuilder sb2=new StringBuilder();
		sb2.append("gcd("+a+", "+b+") = ");
		
		
		
		return a;
	}
	
	public static BigInteger extendedEuclidGCDBigInt(BigInteger a, BigInteger b, BigInteger [] xy)
	{
		
		return a;
	}
}
