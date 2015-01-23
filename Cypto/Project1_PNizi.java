import java.math.BigInteger;

public class Project1_PNizi 
{
	public static void main(String [] args)
	{
		//Test Program 1
		//System.out.println(primeFactorization(92348239921L));
		
		//Test Program 2
		BigInteger [] arr=new BigInteger[3];
		BigInteger num1=new BigInteger("623346263423463462346673774536");
		BigInteger num2 =new BigInteger("234234123465677754556565477754445");
		
		extendedEuclidGCDBigInt(num1, num2, arr);
		
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

	public static long extendedEuclidGCD(long a, long b, long [] xy)
	{
		long outputA=a, outputB=b;
		long x = 0, y = 1, lastx = 1, lasty = 0, temp, tempQ=0;
		 while (b != 0)
		 {
        		//calculate quotient and remainder
        		  long q = a / b;
        		  long r = a % b;
        		  //update values
        		  a = b;
        		 b = r;
            
            		//update quotient 
        		  if(r!=0)
            		tempQ=r;
        		 //calculate next x
        		  temp = x;
            		x = lastx - q * x;
            		lastx = temp;
        		 //calculate next y
        		 temp = y;
        		 y = lasty - q * y;
            		lasty = temp;            
		 }
        	System.out.println("gcd("+outputA+", "+outputB+")"+" = "+tempQ+
        		", and "+ tempQ +" = ("+ lastx+")("+outputA+") + ("+lasty+")("+outputB+").");
        	return tempQ;
	}
	
	public static BigInteger extendedEuclidGCDBigInt(BigInteger a, BigInteger b, BigInteger []xy)
	{
		
		BigInteger outputA=a, outputB=b;
		BigInteger zero=new BigInteger("0");
		BigInteger x = new BigInteger("0");
		BigInteger y =new BigInteger("1");
		BigInteger lastx = new BigInteger("1"); 
		BigInteger lasty =new BigInteger("0"); 
		BigInteger temp=new BigInteger("0"); 
		BigInteger tempQ=new BigInteger("0");
		
        while (!b.equals(zero))
        {
	 	//calculate quotient and remainder
            BigInteger q = a.divide(b);
            BigInteger r = a.mod(b);
            //update values
            a=b;
            b=r;
            
            //update quotient 
            if(!r.equals(zero))
            	tempQ=r;
            //calculate next x
            temp=x;
            x=lastx.subtract(q.multiply(x));
            lastx = temp;
            //calculate next y
            temp=y;
            y=lasty.subtract(q.multiply(y));
            lasty=temp;            
        }
        System.out.println("gcd("+outputA+", "+outputB+")"+" = "+tempQ+
        		", and "+ tempQ +" = ("+ lastx+")("+outputA+") + ("+lasty+")("+outputB+").");
        return tempQ;
	}
}
