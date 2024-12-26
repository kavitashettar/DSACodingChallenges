package com.dsa.gfg.intro;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Factorial {

	public static long factorial(int N) {
		int res = 1, i;
		for (i = 2; i <= N; i++)
			res *= i;
		return res;
	}

	public static BigInteger factorialForLargeNo(int N) {
		BigInteger res = BigInteger.ONE;
		for (int i = 2; i < N; i++) {
			res = res.multiply(BigInteger.valueOf(i));
		}
		return res;

	}

	public static int digitsInFactorialBD(int N) {
		BigDecimal res = BigDecimal.ONE;
		if (N >= 1 && N <= 100000) {
			for (int i = 2; i <= N / 2; i++) {
				res = res.multiply(BigDecimal.valueOf(i));
			}
			res = res.multiply(BigDecimal.valueOf(2));
			res = (N % 2) == 0 ? res : res.multiply(BigDecimal.valueOf(N));
		}
		return (int) Math.floor(Math.log10(res.doubleValue()) + 1);

	}

	public static int countDigit(int N) {

		if (N / 10 == 0)
			return 1;
		return 1 + countDigit(N / 10);
	}

	public static int digitsInFactorialOld(int N) {
		BigDecimal res = BigDecimal.ONE;
		int d = 0;
		if (N >= 1 && N <= 100000) {

			for (int i = 2; i <= N / 2; i++) {
				res = res.multiply(BigDecimal.valueOf(i));
			}

			d = (int) Math.floor(Math.log10(res.doubleValue()) + 1);
		}
		return d;
	}

	public static int digitsInFactorialByArray(int N) {

		int res[] = new int[10000000];

		// Initialize result
		res[0] = 1;
		int res_size = 1;
		// Apply simple factorial formula
		// n! = 1 * 2 * 3 * 4...*n

		for (int x = 2; x <= N / 2; x++)
			res_size = multiply(x, res, res_size);

		return res_size * 2;

	}

	static int multiply(int x, int res[], int res_size) {
		int carry = 0; // Initialize carry

		// One by one multiply n with individual
		// digits of res[]
		for (int i = 0; i < res_size; i++) {
			int prod = res[i] * x + carry;
			res[i] = prod % 10; // Store last digit of
								// 'prod' in res[]
			carry = prod / 10; // Put rest in carry
		}

		// Put carry in res and increase result size
		while (carry != 0) {
			res[res_size] = carry % 10;
			carry = carry / 10;
			res_size++;
		}
		return res_size;
	}

	// Given an integer N. Find the number of digits that appear in its factorial.
	// Factorial is defined as, factorial(n) = 1*2*3*4……..*N and factorial(0) = 1.

	static int digitsInFactorial(int N) {
		double sum = 0.0;
		// if (N >= 1 && N <= 100000) {

		while (N != 0) {
			sum += Math.log10(N);
			N--;
		}
		// }
		return (int) Math.floor(sum) + 1;
	}

	public static void main(String[] args) {
		// System.out.println(factorial(120));
		// System.out.println(factorialForLargeNo(120));
		// System.out.println(countDigit(factorialForLargeNo(120)));
		System.out.println(digitsInFactorial(100005));
	}
}
