package com.dsa.gfg.contest;

public class Test {
	
	public static void main(String[] args) {
		// array of int 
		// max element 
		int a[] = {30 , 20, 10 , 80};
		
		int maxElement = Integer.MIN_VALUE;
		for(int i=0;i< a.length ;i++) {
			if(a[i] > maxElement) {
				maxElement = a[i];
			}
		}
		
		System.out.println(maxElement);
		
	}

}
