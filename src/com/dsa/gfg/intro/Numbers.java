package com.dsa.gfg.intro;

public class Numbers {

	 static int missingNumber(int array[], int n) {
	        int[] temp = new int[n];
	        int maxElement =Integer.MIN_VALUE;
	        for(int i=0;i<array.length;i++){
	        	temp[array[i]-1]++;
	        }
	        
	       for(int i=0;i<n;i++){
	            if(temp[i] == 0){
	                return i+1;
	            }
	            
	        }
	        return 0;
	    }
	 
	 public static void main(String[] args) {
		 int a[]= {1, 2, 3, 5};
		 System.out.println(missingNumber(a, 5));
	}
}
