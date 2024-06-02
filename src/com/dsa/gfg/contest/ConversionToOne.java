package com.dsa.gfg.contest;

import java.util.Scanner;

public class ConversionToOne {

    public static long minOperations(long n)
    {
        long count =0l;
        if(n <= 1)
            return count;
            
        while(n>1){
            if(n % 2 ==0)
                n= n/2;
            else if (n % 4 == 1||n==3)
                n -= 1;
            else 
                n=n-1;
            count++;
        }
        
        
        return count;
    }

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();

		while (testcases-- > 0) {
			long n = sc.nextLong();
			System.out.println(ConversionToOne.minOperations(n));

		}
	}

}
