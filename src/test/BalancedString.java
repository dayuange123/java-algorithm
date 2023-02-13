package test;

import java.util.HashMap;
import java.util.Map;

public class BalancedString {

	public static void main(String[] args) {
		System.out.println();
		new BalancedString().balancedString("WWQQRRRRQRQQ");
	}

	public int balancedString(String s) {
		int q = 0, w = 0, e = 0, r = 0;
		char[] chars = s.toCharArray();

		for (char c : chars) {
			if (c == 'Q') {
				q++;
			} else if (c == 'W') {
				w++;
			} else if (c == 'E') {
				e++;
			} else {
				r++;
			}
		}
		int needLen = s.length() / 4;

		int min = 0;
		Map<Character, Integer> needMap = new HashMap<>();
		if (q > needLen) {
			needMap.put('Q', q - needLen);
			min += q - needLen;
		}
		if (w > needLen) {
			needMap.put('W', w - needLen);
			min += w - needLen;

		}
		if (e > needLen) {
			needMap.put('E', e - needLen);
			min += e - needLen;

		}
		if (r > needLen) {
			needMap.put('R', r - needLen);
			min += r - needLen;

		}
		if (needMap.size() == 0) {
			return 0;
		}
		int left = 0;
		int right = 0;
		int result = s.length() + 1;
		while (right < s.length() || left < s.length()) {
			if (needMap.getOrDefault('Q', 0) <= 0
					&& needMap.getOrDefault('W', 0) <= 0
					&& needMap.getOrDefault('E', 0) <= 0
					&& needMap.getOrDefault('R', 0) <= 0) {
				result = Math.min(right - left, result);
				if (result == min) {
					break;
				}
				char aChar = chars[left];
				if (needMap.containsKey(aChar)) {
					needMap.put(aChar, needMap.get(aChar) + 1);
				}
				left++;
			} else if (right == s.length()) {
				char aChar = chars[left];
				if (needMap.containsKey(aChar)) {
					needMap.put(aChar, needMap.get(aChar) + 1);
				}
				left++;
			} else {
				char aChar = chars[right];
				if (needMap.containsKey(aChar)) {
					needMap.put(aChar, needMap.get(aChar) - 1);
				}
				right++;
			}
		}
		return result;
	}
}
