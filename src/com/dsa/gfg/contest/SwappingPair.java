package com.dsa.gfg.contest;

import java.util.HashSet;
import java.util.Set;

public class SwappingPair {

	static long findSwapValues(long a[], int n, long b[], int m) {
		long aSum = 0, bSum = 0;
		for (int i = 0; i < n; i++) {
			aSum += a[i];
		}
		Set<Long> set = new HashSet<Long>();
		for (int i = 0; i < m; i++) {
			bSum += b[i];
			set.add(b[i]);
		}
		//Basecase
		if(aSum == bSum)
			return 1;
		
		long diff = Math.abs(aSum - bSum);
		for (int i = 0; i < n; i++) {
			long searchKey = diff - a[i];
			boolean isPresent = set.contains(searchKey);
			
			if(isPresent) {
				//Basecase
				if((aSum-a[i] + searchKey) == (bSum - searchKey + a[i]))
					return 1;
			}
				
		}
		return -1;
	}

//	static long binarySearch(long b[], int low, int high, long key) {
//		int mid = (low + high) / 2;
//
//		if (b[mid] == key)
//			return 1;
//		if (b[mid] < key)
//			binarySearch(b, (mid + 1), high, key);
//		else
//			binarySearch(b, low, (mid - 1), key);
//		return -1;
//	}

	public static void main(String[] args) {
		/*
		 * int n = 6, m = 4; long a[] = { 4, 1, 2, 1, 1, 2 }; long b[] = { 3, 6, 3, 3 };
		 */
		
		/*
		 * int n = 4, m = 4; long a[] = { 1, 2,3,4 }; long b[] = { 1, 2,3,4 };
		 */		
		
		int n = 4, m = 4; long a[] = { 10,10,10,10 }; long b[] = { 5,5,5,10};
		System.out.println(findSwapValues(a, n, b, m));
	}
}
