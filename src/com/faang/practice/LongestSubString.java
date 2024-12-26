package com.faang.practice;

import java.util.Arrays;

public class LongestSubString {

	final int NO_OF_CHARS = 256;

	int longestUniqueSubsttr(String str) {
		int n = str.length();

		int res = 0; // result

		// last index of all characters is initialised
		// as -1
		int[] lastIndex = new int[NO_OF_CHARS];
		Arrays.fill(lastIndex, -1);

		// Initialise start of current window
		int i = 0;

		// Move end of current window
		for (int j = 0; j < n; j++) {

			// Find the last index of str[j]
			// Update i (starting index of current window)
			// as maximum of current value of i and last
			// index plus 1
			i = Math.max(i, lastIndex[str.charAt(j)] + 1);

			// Update result if we get a larger window
			res = Math.max(res, j - i + 1);
			System.out.print(str.substring(j, res-1));

			// Update last index of j.
			lastIndex[str.charAt(j)] = j;
		}
		return res;
	}

	public int lengthOfLongestSubstring(String s) {

		String[] strArr = s.split("");
		System.out.println("strArr : " + strArr.length);

		String longestSubString = "";
		String tempStr = "";
		if (strArr.length == 1) {
			tempStr = tempStr.concat(s);
			longestSubString = tempStr;
		} else {
			for (String str : strArr) {
				if (!tempStr.isEmpty() && tempStr.contains(str)) {
					if (tempStr.length() > longestSubString.length()) {
						longestSubString = tempStr;
						System.out.println("longestSubString : " + longestSubString);
					}
					tempStr = "";

				}
				tempStr = tempStr.concat(str);
				System.out.println("longestSubString : " + longestSubString);

			}
		}
		return longestSubString.length();

	}

	public static void main(String[] args) {

		LongestSubString l = new LongestSubString();
		System.out.println(l.longestUniqueSubsttr("abcabcbb"));
		System.out.println(l.longestUniqueSubsttr(" "));
		System.out.println(l.longestUniqueSubsttr("dvdf"));

	}
}
