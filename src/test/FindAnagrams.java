package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/23
 * Description:
 */
public class FindAnagrams {


	public List<Integer> findAnagrams(String s, String p) {

		List<Integer> list = new ArrayList<>();
		if (p.length() > s.length()) {
			return list;
		}
		int[] array1 = new int[26];
		int[] array2 = new int[26];

		for (int i = 0; i < p.length(); i++) {
			array1[p.charAt(i) - 'a'] = array1[p.charAt(i) - 'a'] + 1;
			array2[s.charAt(i) - 'a'] = array2[s.charAt(i) - 'a'] + 1;
		}
		int left = 0;

		for (int i = p.length(); i < s.length(); ++i) {

			if (Arrays.equals(array1, array2)) {
				list.add(left);
			}

			array2[s.charAt(left) - 'a'] = array2[s.charAt(left) - 'a'] - 1;
			array2[s.charAt(i) - 'a'] = array2[s.charAt(i) - 'a'] + 1;

			left++;
		}

		if (Arrays.equals(array1, array2)) {
			list.add(left);
		}
		return list;
	}
}
