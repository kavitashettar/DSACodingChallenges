package com.dsa.gfg.intro;

public class BitwiseOperators {

	/*
	 * Function to get no of set bits in binary representation of positive integer n
	 */
	static int countSetBits(int n) {
		int count = 0;
		while (n > 0) {
			count += n & 1;
			n >>= 1;
		}
		return count;
	}

	public static int countBitsFlip(int a, int b) {
		int noFlips = 0, value = 0;
		if ((a >= 1 && a <= 1000000) && (b >= 1 && b <= 1000000)) {
			int n = a + b;
			while (n > 0) {
				noFlips = noFlips + (n & 1);
				n = n / 2;
			}
		}
		return noFlips;
	}

	// Trail of ones
	// Input: n = 2
	// Output: 1
	// Explanation: There are 4 strings of length 2,
	// the strings are 00, 01, 10, and 11. Only the string 11 has consecutive 1's.
	static int numberOfConsecutiveOnes(int n) {
		int totalCount = 0;
		// for (int i = 0; ((int) Math.log(i) + 1) < n; i++) {
		int next_bit_count = 0;
		int i = 0;
		while (next_bit_count <= n) {
			int ConSetCount = 0;
			int j=i;
			int max_count=0;
			while (j != 0) {
				if ((j & 1) == 0) {
					max_count = Math.max(ConSetCount, max_count);
					ConSetCount = 0;
				} else {
					ConSetCount++;
				}
				j >>= 1;
			}
			System.out.println(i + " " + ConSetCount);

			if (Math.max(max_count,ConSetCount) > 1)
				totalCount++;
			i++;
			next_bit_count = ((int) (Math.log(i)/Math.log(2)) + 1);

		}

		return totalCount;
	}

	// Function to return sum of count of set bits in the integers from 1 to n.
	public static int sumCountSetBitsx(int n) {
		int[] tbl = new int[n + 1];
		int sum = 0;

		tbl[0] = 0;

		for (int i = 1; i <= n; i++) {

			int count = tbl[i & i - 1] + 1;
			tbl[i] = count;
			System.out.println(i + ":" + tbl[i]);
			/*
			 * sum =sum + tbl[i & n] + tbl[(i>>8) & n] + tbl[(i>>16) & n] + tbl[(i>>24) &
			 * n];
			 */
			sum = sum + count;
		}
		return sum;
	}

	public static int sumCountSetBits(int n) {
		int[] tbl = new int[n + 1];
		int sum = 0;

		tbl[0] = 0;

		for (int i = 1; i <= n; i++) {

			int count = tbl[i & i - 1] + 1;
			tbl[i] = count;
			sum = sum + count;
		}
		return sum;
	}

	public static int posOfRightMostDiffBit(int m, int n) {
		if (m == n)
			return -1;
		int k = Math.min(m, n);
		/*
		 * while(min>0){ if((m % 2 ==0) && (n % 2 ==0)) return res; else res = res+1;
		 * min = min/2; m =m/2; n=n/2; }
		 */
		/*
		 * int count=1; while(count < k) { System.out.println("m ="+ m +"  , n ="+n);
		 * System.out.println(m & 1); System.out.println(n & 1); if((m & 1) == (n & 1))
		 * { m = m >> 1; n = n >> 1; count++; } else return count;
		 * 
		 * } return count;
		 */

		int pos = 1;
		while (pos <= k) {
			if ((m & 1) == (n & 1)) {
				m = m >> 1;
				n = n >> 1;
			} else
				return pos;
			pos++;
		}
		return pos;

	}

	// Function to swap odd and even bits.
	public static int swapBits(int n) {
		int res = 0;
		if (n >= 1 && n <= 1000000000) {
			int evenBits = n & 0xAAAAAAAA;
			int oddBits = n & 0x55555555;
			System.out.println(evenBits);
			evenBits >>= 1;
			oddBits <<= 1;
			res = (evenBits | oddBits);

		}
		return res;

	}

	/*
	 * Function to calculate the longest consecutive ones N: given input to
	 * calculate the longest consecutive ones
	 */
	public static int maxConsecutiveOnes(int N) {
		int maxCount = 0;
		if (N >= 1 && N <= 1000000) {
			int count = 0;
			while (N != 0) {
				if ((N & 1) == 0) {
					maxCount = Math.max(count, maxCount);
					count = 0;
				} else {
					count++;
				}
				N >>= 1;
			}
			maxCount = Math.max(count, maxCount);
		}
		return maxCount;

	}

	// Function for finding maximum AND value.
	// Naive
	public static int maxANDNaive(int arr[], int N) {
		int maxAndValue = 0;
		if (N >= 1 && N <= 100000) {

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (i != j) {

						maxAndValue = Math.max(maxAndValue, (arr[i] & arr[j]));

					}
				}
			}

		}
		return maxAndValue;

	}

	// Function for finding maximum AND value.
	// best case
	public static int maxAND(int arr[], int N) {
		int maxAndValue = 0;
		if (N >= 1 && N <= 100000) {

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (i != j) {

						maxAndValue = Math.max(maxAndValue, (arr[i] & arr[j]));

					}
				}
			}

		}
		return maxAndValue;

	}

	public static void main(String[] args) {
		int x = 3, y = 6;
		// System.out.println(x & y);

		// System.out.println(x & 1);

		int i = 9;
		// System.out.println(countSetBits(i));
		// System.out.println(sumCountSetBits(i));

		int m = 52, n = 4;
		// System.out.println(posOfRightMostDiffBit(m,n));

		m = 11;
		n = 9;
		// System.out.println(posOfRightMostDiffBit(m,n));

		// int a = 10 ,b=20;

		// System.out.println(countBitsFlip(a,b));

		int sb = 23;
		// System.out.println(swapBits(sb));

		int N = 222; // 14 : 3
		// System.out.println(maxConsecutiveOnes(N));

		int mN = 4;
		int arr[] = { 4, 8, 12, 16 };
		// int arr[] = {4, 8, 16, 2};
		// System.out.println(maxAND(arr, mN));

		System.out.println(numberOfConsecutiveOnes(5));

	}
}
