package com.faang.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ArraySolutions {
	
	
		// Two Sum - Unsorted and sorted
		//Only one valid answer exists.
	   public int[] twoSum(int[] nums, int target) {
	        int res[] = new int[2];
	        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();

	        for(int i=0;i<nums.length ;i++){
	            int diff = target - nums[i];
	            if(hs.containsKey(diff)){
	                res[0] = hs.get(diff);
	                res[1] = i;
	            }
	            hs.put(nums[i],i);
	        }
	        return res;
	    }

	   // For Sorted Array using Two Pointer
	   // 
	   public int[] twoSumEfficient(int[] numbers, int target) {
	        int[] res = new int[2];
	        int n = numbers.length;
	        int low = 0;
	        int high = n-1;

	        while(numbers[low] + numbers[high] != target){
	            if(numbers[low] + numbers[high] < target)
	                low++;
	            else 
	                high--; 
	        }
	        res[0] =low+1;
	        res[1] = high+1;
	        return res;

	    }
	static int maxIndexDiff(int a[], int n) {
		int maxIndexDiff = -1;
		int Lmin[] = new int[n];
		int RMax[] = new int[n];

		Lmin[0] = a[0];
		for (int i = 1; i < n; i++) {
			Lmin[i] = Math.min(a[i], Lmin[i - 1]);
		}

		RMax[n - 1] = a[n - 1];
		for (int j = n - 2; j >= 0; j--) {
			RMax[j] = Math.max(a[j], RMax[j + 1]);
		}
		int i = 0;
		int j = 0;
		while (i < n && j < n) {
			if (Lmin[i] <= RMax[j]) {
				maxIndexDiff = Math.max(maxIndexDiff, j - i);
				j++;
			} else
				i++;
		}

		return maxIndexDiff;
	}

	// Function to find largest and second largest element in the array
	public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[]) {
		int max = -1;
		int secondMax = -1;
		if (sizeOfArray <= 1) {
			max = arr[0];
		}

		for (int i = 0; i < sizeOfArray; i++) {
			if (arr[i] > max) {
				secondMax = max;
				max = arr[i];
			} else if (arr[i] < max && arr[i] > secondMax)
				secondMax = arr[i];
		}
		ArrayList<Integer> resAL = new ArrayList<Integer>();
		resAL.add(max);
		resAL.add(secondMax);
		return resAL;
	}

	static int median(int A[], int N) {

		Arrays.sort(A);
		int mid = N / 2;
		int res = N % 2 == 0 ? (A[mid] + A[mid - 1]) / 2 : A[mid];
		int median = (int) Math.floor(res);
		// Your code here
		// If median is fraction then conver it to integer and return
		return median;
	}

	// Function to find median of the array elements.
	static int mean(int A[], int N) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += A[i];
		}
		int mean = (int) Math.floor(sum / N);
		return mean;
	}

	// Function to reverse every sub-array group of size k.
	static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {

		for (int i = 0; i < n; i += k) {
			int left = i;
			int right = Math.min(i + k - 1, n - 1);

			while (left < right) {

				int temp = arr.get(left);
				arr.set(left, arr.get(right));
				arr.set(right, temp);

				left++;
				right--;

			}
		}

	}

	// Function to rotate an array by d elements in counter-clockwise direction.
	static void rotateArr(int arr[], int d, int n) {
		reverse(arr, 0, d - 1);
		reverse(arr, d, n - 1);
		reverse(arr, 0, n - 1);
	}

	static void reverse(int arr[], int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	// Function to find the leaders in the array.
	static ArrayList<Integer> leaders(int arr[], int n) {
		ArrayList<Integer> leaderList = new ArrayList<Integer>();
		int currentLeader = arr[n - 1];
		leaderList.add(currentLeader);
		for (int i = n - 2; i >= 0; i--) {
			if (currentLeader <= arr[i]) { // = bcz if the repeated number is leader and have to display
				leaderList.add(0, arr[i]);// adding at the beginning since traversing from right to left will have
											// highest numbers
				currentLeader = arr[i];
			}
		}
		return leaderList;
		/*
		 * leaderList.add(0, arr[i]);// adding at the beginning since traversing from
		 * right to left will have highest numbers
		 * 
		 * Collections.sort(leaderlist);
		 */
	}

	// arr[]: input array
	// num: size of array
	// Function to check if array is sorted and rotated
	public static boolean checkRotatedAndSorted(int arr[], int num) {

		boolean isRotated = false;
		boolean isSorted = false;

		for (int i = 0; i < num; i++) {
			if ((arr[i] >= arr[i + 1]) || (arr[i] <= arr[i++])) {

			}
		}
		return isRotated && isSorted;

	}

	// Function to find element with more appearances between two elements in an
	// array.
	static int majorityWins(int arr[], int n, int x, int y) {
		int xCounter = 0, yCounter = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == x) {
				xCounter++;
			} else if (arr[i] == y) {
				yCounter++;
			}
		}
		if (xCounter == yCounter)
			return x < y ? x : y;
		else if (xCounter > yCounter)
			return x;
		else
			return y;

	}

	static List<Integer> pattern(int N) {
		List<Integer> al = new ArrayList<Integer>();
		// generateSequence(al, N,N, true);
		printBoth(al, N);
		return al;

	}

	static void generateSequence(List<Integer> al, int N, int seqNo, boolean isIncrement) {
		if (al.isEmpty() && seqNo == N) {
			al.add(N);
			if (N <= 1)
				return;
		} else if (!al.isEmpty() && seqNo == N)
			return;

		if (isIncrement && seqNo > 0) {

			seqNo -= 5;

			if (seqNo <= 0)
				isIncrement = false;

		} else if (!isIncrement) {
			seqNo = seqNo + 5;
		}
		al.add(seqNo);
		generateSequence(al, N, seqNo, isIncrement);

	}

	static void printBoth(List<Integer> result, int num) {
		if (num <= 0) {
			result.add(num);
			return;
		}
		result.add(num);
		printBoth(result, num - 5);
		result.add(num);
	}

	public static int numberofElementsInIntersection(int a[], int b[], int n, int m) {
		/*
		 * Set<Integer> c = new HashSet<Integer>(); for (int i = 0; i < n; i++) { for
		 * (int j = 0; j < m; j++) { if (a[i] == b[j]) { c.add(a[i]); } } } return
		 * c.size();
		 */

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			Integer key = Integer.valueOf(a[i]);
			hm.put(key, 1);
		}
		for (int i = 0; i < m; i++) {
			Integer key = Integer.valueOf(b[i]);
			if (hm.containsKey(key)) {
				count++;
			}
		}

		return count;
	}

	// Unique Number of Occurrences
	
	//Expected Time Complexity: O(N)
	//Expected Auxiliary Space: O(N)
	public static boolean isFrequencyUnique(int n, int[] arr) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			Integer key = Integer.valueOf(arr[i]);
			if (map.containsKey(key)) {
				Integer value = map.get(key);
				map.put(key, ++value);
			} else {
				map.put(key, 1);
			}
		}
		Set<Integer> set = new HashSet<Integer>();
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if(set.contains(entry.getValue()))
				return false;
			else
				set.add(entry.getValue());

		}

		return true;
	}

	
	//Function to find all possible unique subsets.
	
	//Expected Time Complexity: O(2N).
	//Expected Auxiliary Space: O(2N * X), X = Length of each subset.
	
	
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
		return null;
        // your code here
    }
    
    //Count pairs in array divisible by K
    //Expected Time Complexity : O(n)
    //Expected Auxiliary Space : O(k)
    
    public static long countKdivPairs(int arr[], int n, int k)
    {
    	// Create a frequency array to count
        // occurrences of all remainders when
        // divided by K
        int freq[] = new int[k];
 
        // Count occurrences of all remainders
        for (int i = 0; i < n; i++)
            ++freq[arr[i] % k];
 
        // If both pairs are divisible by 'K'
        int sum = freq[0] * (freq[0] - 1) / 2;
 
        // count for all i and (k-i)
        // freq pairs
        for (int i = 1; i <= k / 2 && i != (k - i); i++)
            sum += freq[i] * freq[k - i];
        // If K is even
        if (k % 2 == 0)
            sum += (freq[k / 2] * (freq[k / 2] - 1) / 2);
        return sum;
        
        /* OR
         * 
         * 
         * int[] freq = new int[k];
        
        for(int i=0;i< n ;i++)
            ++freq[arr[i] % k];
            
        int count = freq[0] * (freq[0] - 1) / 2;
        
        for(int i=1 ;i<= k/2 && i != (k-i) ;i++)
            count = count + freq[i] * freq[k-i];
        if(k%2 == 0)
            count += (freq[k/2] * (freq[k/2] -1)/2);
        return count;
         */
    }
    
	public static void main(String[] args) {
		// int a[] = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
		// int arr[] = { 2, 1, 2 };
		// System.out.println(maxIndexDiff(a,a.length));
		// System.out.println(largestAndSecondLargest(arr.length, arr));
		// int a1[] = { 1, 2, 19, 28, 5 };
		// int a2[] = { 2, 8, 3, 4 };
		// System.out.println(median (a2, a2.length));
		// System.out.println(mean (a2, a2.length));
		// ArrayList<Integer> AL = new ArrayList<Integer>();
		// AL.add(1);
		// AL.add(2);
		// AL.add(3);
		// AL.add(4);
		// AL.add(5);
		// int k = 3;
		// System.out.println(AL.toString());

		// reverseInGroups(AL, AL.size(), k);
		// System.out.println(AL.toString());
		// int arrRotate[] = {1,2,3,4,5};
		// System.out.println(arrRotate);

		// rotateArr(arrRotate, 2 , arrRotate.length);
		// System.out.println(arrRotate);

		// int AL[] = {1,2,3,4,0};
		// System.out.println(leaders(AL, AL.length));

		// int arr[] = {1,2,3,4,5,6,7,8};
		// System.out.println(majorityWins(arr, arr.length, 1, 7));
		// System.out.println(arr.toString());

		// System.out.println(pattern(1));
		// System.out.println(pattern(16));
		// System.out.println(pattern(0));
		// System.out.println(pattern(-12));
		// int a[] = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
		// int b[] = { 10, 3, 20, 80, 30, 32, 19 };
		// System.out.println(numberofElementsInIntersection(a, b, a.length, b.length));

		// int freqa[] = { 34, 8, 10, 3, 2, 80, 30, 34, 1 };
		//int freqa[] = { 0, -4, -4, 0, -4, -4, -4, 0, 0, 1 };

		//System.out.println(isFrequencyUnique(freqa.length, freqa));
		
		//int arr[] = { 2, 2, 1, 7, 5, 3};
		int[] arr= {4, 5 ,6, 5 ,9, 4, 3};
		System.out.print(countKdivPairs(arr, arr.length, 7));
		

	}

}
