package com.faang.practice.arrays;

public class Arrays {

	
	 public void insertAtIndex(int arr[],int sizeOfArray,int index,int element)
	    {
	          if((sizeOfArray >= 1 && sizeOfArray <= 10000) &&
		            (element >=0 && element <1000000) && 
		            (index >=0 && index <= sizeOfArray-1)){
		                int n = sizeOfArray -1;
		                int pos = index;
		                if(n == pos){
		                    arr[pos] = element;
		                }else{
	    	                for(int i= n-1 ;i >=pos ;i--){
	    	                    arr[i+1] = arr[i];
	    	                }
	                        arr[pos] = element;

		                }
		            }
	    }
	 
	 static int maxIndexDiff(int a[], int n) { 
         int maxDiff = 0;

         if(n>=1 && n<=1000000){
        	 for(int i=0; i<n-1; i++){
        		 if(a[i] >= 0 && a[i] <= 1000000000) {
        			 for(int j=0;j<=n-1;j++) {
        				 if(a[i]<= a[j]) {
        					 maxDiff = Math.max(maxDiff, j-i);
        				 }
        			 }

        		 }
        	 }
         }
         
         if(n>=1 && n<=1000000){
        	 for(int i=0; i<n-1; i++){
        		 if(a[i] >= 0 && a[i] <= 1000000000) {
        			 if(a[i]<= a[i+1]) {
        				// max
        			 }
        			

        		 }
        	 }
         }
	    return maxDiff;
	    }
	 
	public static int equilibriumPoint(long arr[], int n) {

        long sum =0;
        for(int i=0 ;i<n; i++){
            sum =+ arr[i];
        }
        long leftSum =0;
        long rightSum =0;
        for(int i=0; i<n ;i++){
            leftSum += arr[i];
            
            if(leftSum == rightSum){
                return i+1;
            }
        }
        return -1;
	}
	// TC : O(N)
	
	  int missingNumber(int array[], int n) {
	        int x =0;
	        
	        for(int i=0 ;i< n-1 ;i++){
	            x^= array[i];
	        }
	        for(int i=1 ;i<= n;i++){
	            x^=i;
	        }
	        return x;
	    }
	
	public static void main(String[] args) {
		
		Arrays arrObj = new Arrays();
		int sizeOfArray = 6;
		//int arr[]= new int[sizeOfArray];
		int	arr[]= {1, 2, 3, 4, 5,0};
		int index = 5, element = 90;
//		for(int i=0;i<sizeOfArray-1;i++) {
//			System.out.print(arr[i]);
//		}
//		//arrObj.insertAtIndex(arr1, sizeOfArray, index, element);
//		for(int i=0;i<sizeOfArray-1;i++) {
//			System.out.print(arr[i]);
//		}
		int	arr1[]= {1, 2, 3, 4, 5,0};

        System.out.println(maxIndexDiff(arr1, arr1.length));

		
	}
}


