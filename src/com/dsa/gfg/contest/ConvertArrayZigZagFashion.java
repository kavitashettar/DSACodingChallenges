package com.dsa.gfg.contest;

public class ConvertArrayZigZagFashion {

	public static void zigZag(int n, int[] a) {
		boolean flag = true;
		for (int i = 0; i < n - 1; i++) {
			if (flag) {
				if (a[i] > a[i + 1]) {
					// swap(a[i], a[i + 1]);
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
				flag = false;
			} else {
				if (a[i] < a[i + 1]) {
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
				flag = true;
			}
		}
	}

	static void swap(int a, int b) {

	}

	public static void main(String[] args) {
		int n = 7, arr[] = { 4, 3, 7, 8, 6, 2, 1 };
		System.out.println("Before ");
		for (int i = 0; i <= n - 1; i++) {
			System.out.print(arr[i] + " ");
		}
		zigZag(n, arr);
		System.out.println("After ");

		for (int i = 0; i <= n - 1; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
