package com.dsa.gfg.contest;

import java.util.Arrays;

public class GetTheShadow {

	public static int[] solveOld(int N, int a[]) {
		int[] res = new int[2];
		// Arrays.sort(a);
		for (int i = 0; i < N; i++) {
			int abs_val = Math.abs(a[i]);
			if (a[abs_val-1] > 0)
				a[abs_val-1] = -a[abs_val];
			else
				res[0] = abs_val;

		}
		for (int i = 1; i < N; i++) {
			if (i != a[i - 1])
				res[1] = i;
		}
		return res;
	}

	
	public static int[] solve(int N, int a[]) {
		int[] res = new int[2];
		int[] temp = new int[N];
		for (int i = 0; i < N; i++) {
			temp[a[i] - 1]++;
			if (temp[a[i]-1] > 1) {
				res[0] = a[i];
			}
		}

		for (int i = 0; i < N; i++) {
			if (temp[i] == 0) {
				res[1] = i + 1;
			}
		}
		return res;
	}
	public static void main(String[] args) {

		int a[] = { 1, 3, 4, 2, 2 };
		int res[] = solve(a.length, a);
		System.out.println(res[0] + " " + res[1]);

	}
}
