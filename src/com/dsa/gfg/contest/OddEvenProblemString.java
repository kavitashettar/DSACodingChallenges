package com.dsa.gfg.contest;

public class OddEvenProblemString {

	public static void main(String[] args) {

		String s = "abbbbccc";
		oddEven(s);

	}

	private static void oddEven(String s) {
		int even = 0, odd = 0;
		int alphabetsSize = 26;
		int[] freq = new int[alphabetsSize];
		int startInd = 'a';
		for (int i = 0; i < s.length(); i++) {
			int ind = s.charAt(i);
			freq[ind - startInd]++;
		}
		for (int i = 0; i < freq.length; i++) {
			if ((i + 1) % 2 == 0 && (freq[i + 1] % 2 == 0)) {
				even++;
			}
			if ((i + 1) % 2 == 1 && (freq[i] % 2 == 1)) {
				even++;
			}

		}

	}
}
