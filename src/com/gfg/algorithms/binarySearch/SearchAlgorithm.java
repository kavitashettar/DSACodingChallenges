package com.gfg.algorithms.binarySearch;

public class SearchAlgorithm {

    static int searchInSortedRec(int arr[], int N, int K)
    {
        int low=1, high= N;
        int pos = binarySearchRec(arr, N, K, low ,high);
		return pos;
    }
    
    static int binarySearchRec(int arr[], int N, int K, int low, int high){
        
        if(low > high){
            return -1;
        }else if(low < high){
            int mid = (low + high)/2;
            if(arr[mid] == K){
                return mid;
            }else if(arr[mid] > K){
                return binarySearchRec(arr,N, K, mid+1,high);
            }else
                return binarySearchRec(arr,N,K,low, mid-1);
        }
        return -1;
    }
    
    static int searchInSorted(int arr[], int N, int K) 
    { 
        
           int low =0, high = N-1;
           while(low<= high){
               int mid = (low + high) / 2;
               if(arr[mid] > K){
                   low = mid + 1;
               }else if(mid == 0 || arr[mid] != arr[mid -1])
                    return 1;
                else
                    high = mid -1;
           }
           return -1;
           
    }
    
    static int findFloor(long arr[], int n, long x)
    {
    	int low = 0,  high = n-1;
        long minMax = 0;
        if(x==0)
            return -1;
        if(x >= arr[n-1])
            return n-1;
            
        if((n >= 1 && n<=10000000) &&
        (x >= Long.MIN_VALUE && x <= arr[n-1])){
            while(low <= high){
                int mid = (low + high) /2;
                if(mid>0){
                    if(arr[mid] <= x && arr[mid] >= arr[mid -1]){
                        return mid;
                    }else if(arr[mid] > x)
                    	high = mid - 1;
                    else 
                	    low = mid+1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
		//long arr[] = {1,2,8,10,11,12,19};
    	long arr[] = {71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87 ,88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112};

		long x = 68;
    	int floor = findFloor(arr, arr.length,x ); 
    	System.out.println("floor :"+floor);
    	//
    	int arri[] = {1,2,8,10,11,12,19};
    	
		int xi = 5;
    	System.out.print(searchInSorted(arri, arri.length, xi));

	}
}
