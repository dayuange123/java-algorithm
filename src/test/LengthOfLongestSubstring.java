package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/22
 * Description:
 */
public class LengthOfLongestSubstring {
	public static void main(String[] args) {
		System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("tmmzuxt"));
	}

	public int lengthOfLongestSubstring(String s) {

		int left = 0;
		int result = 0;

		Map<Character, Integer> record = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Integer index = record.get(c);
			record.put(c, i);
			if (index == null || (index + 1 < left)) {
				result = Math.max(result, i - left + 1);
			} else {
				left = index + 1;
			}
		}
		return result;
	}

}
