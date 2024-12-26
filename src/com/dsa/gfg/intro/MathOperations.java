package com.dsa.gfg.intro;

import java.util.Arrays;

/**
 * @author star
 *
 */
public class MathOperations {
	public static boolean isPrimeAvg(int N) {
		if (N >= 1 && N <= 1000000000) {
			if (N <= 1)
				return false;
			else if (N == 2 || N == 3)
				return true;
			else if (((N % 2) == 0) || ((N % 3) == 0)) {
				return false;
			}
			for (int i = 5; i <= Math.sqrt(N); i++) {
				if (N % i == 0 || N % (i + 2) == 0)
					return false;
			}
		}
		return true;
	}
	
	//	A prime number is a number which is only divisible by 1 and itself.
	//Given number N check if it is prime or not.
	public static boolean isPrime(int n) 
	{ 
	    // Corner cases 
	    if (n <= 1) 
	        return false; 
	    if (n <= 3) 
	        return true; 
	 
	    // This is checked so that we can skip 
	    // middle five numbers in below loop 
	    if (n % 2 == 0 || n % 3 == 0) 
	        return false; 
	 
	    for (int i = 5; i * i <= n; i = i + 6) 
	        if (n % i == 0 || n % (i + 2) == 0) 
	            return false; 
	 
	    return true; 
	} 
	
	public static int exactly3DivisorsOld(int N)
    {
        int totalCount =0;

        if(N >= 1 && N<=1000000000){
            if(N <= 3)
                return 0;
            for(int i= 4 ; i<= N; i++){
                int divCount =0;
                for(int j= 1; j<= i/2; j++){
                    if(i % j == 0){
                        divCount++;
                    }
                }
                // add number itself 
                divCount++;
                if(divCount ==3)
                    totalCount++;
            }
        }
        return totalCount;
    }
	
	public static int exactly3DivisorsAvg(int N)
    {
        int totalCount =0;
        
        boolean prime[] = new boolean[N+1];
        Arrays.fill(prime, true);
        
        prime[0] = prime[1] = false; 
        
        for(int p= 2 ; p * p <= N ;p++) {
        	if(prime[p] == true) {
            	for(int i= p * 2 ; i <= N ; i+=p) {
            		prime[i] = false;
            	}

        	}
        }
        System.out.println(prime);
        for(int i =0 ;i * i <= N ; i++) {
        	if(prime[i]) {
        		totalCount++;
        	}
        }
        
        return totalCount;
    }
	
	//Given a positive integer value N. 
	//The task is to find how many numbers less than or equal to N 
	//have numbers of divisors exactly equal to 3.
	
	
	public static int exactly3Divisors(int N)
    {
		int totalCount =0;

        if(N >= 1 && N<=1000000000){
        	if(N <= 3)
                return 0;
        	for(int p= 2 ; p*p<= N; p++){
        		 if(isPrime(p)) {
        			 int sq = (int)Math.sqrt(p); 
        			 
         		    // Check whether number is perfect 
         		    // square or not 
         		    if (sq * sq != N)
         		    	totalCount++;
        		 }
        	}
        }
            
        return totalCount;
    }
	
	public static long sumUnderModulo(long a, long b) {
		if ((a >= 1 && a <= (Math.pow(2, 63) - 1)) && (b >= 1 && b <= (Math.pow(2, 63) - 1))) {
			/*
			 * long sum = Long.sum(a, b); long modVal = (long) (Math.pow(10, 9) + 7); return
			 * (sum % modVal);
			 */
			
			long m = (long) (Math.pow(10, 9) + 7);
			long sum = ((a % m) + (b % m)) % m;
			return sum;
		}
		return 0l;
	}
	
	public static long multiplicationUnderModulo(long a, long b) {
		if ((a >= 1 && a <= (Math.pow(2, 63) - 1)) && (b >= 1 && b <= (Math.pow(2, 63) - 1))) {
			
			long m = (long) (Math.pow(10, 9) + 7);
			long prod = ((a % m) * (b % m)) % m;
			return prod;
		}
		return 0l;
	}
	
	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
    //	The modular inverse of a mod m exists only if a and m are relatively prime 
	//	i.e. gcd(a, m) = 1. 
	//	Hence, for finding the inverse of an under modulo m, if (a x b) mod m = 1 
	//	then b is the modular inverse of a.
	public static int modInverse(int a, int m)
    {
       int res = -1;
       if((a >= 1 && a<= 10000) &&
    	  (m >= 1 && m<= 10000)){
    	   
    	   for(int b = 1 ; b < m ; b++) {
    		   if(((a % m) * (b % m)) % m == 1)
    			   return b;
    	   }
    	   
       }
       return res;
    }
	
	public static double termOfGPOld(int A,int B,int N)
    {
		double nthTerm = 0d;
        if((A >= -100 && A <= 100) && 
           (A >= -100 && A <= 100) &&
           (N >= 1 && N <=5)){
                if(N == 1)
                    return (double)A;
                if(N == 2)
                    return (double)B;
                int r = B / A;
                if(r == 1) {
                	r = (B - A) * ( N- 1);
                    nthTerm = (double) (A + r);
                }
                else if(r > 1)
                    nthTerm = (double) (A * Math.pow(r,N-1));
           }
        return nthTerm;
       
    }
	
	public static double termOfGP(int A,int B,int N)
    {
		double nthTerm = 0d;
        if((A >= -100 && A <= 100) && 
           (A >= -100 && A <= 100) &&
           (N >= 1 && N <=5)){
        	//Your code here
            double r = (double)B/(double)A;
            nthTerm = A*Math.pow(r,N-1);
           }
        return nthTerm;
       
    }
	
	public static void main(String[] args) {
		//System.out.print(exactly3Divisors(100000000));
		
		//long a = 9223372036854775807l;
		//long b = 9223372036854775807l;
		
		//long a = 1000000007l ,b = 1000000007l;
		//long a = 9223372036854775807l,b= 9223372036854775807l;
		
		//System.out.println(sumUnderModulo(a, b));
		//System.out.println(multiplicationUnderModulo(a, b));
		
		//int a = 10,m = 17;
		//System.out.println(modInverse(a, m));
		
		//int A= 1, B = 2, N = 5;
		
		//int A= 84 ,B = 87, N = 3;
		
		int A= 87 ,B = 93, N = 5;
		System.out.println(termOfGP(A, B, N));

		
		
	}
}
