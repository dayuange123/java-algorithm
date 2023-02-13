package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/22
 * Description:
 */
public class CheckInclusion {


	public boolean checkInclusion(String s1, String s2) {
		if (s1.length()>s2.length()){
			return false;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			char s1c = s1.charAt(i);
			Integer s1Val = map.getOrDefault(s1c, 0);
			if (s1Val + 1 == 0) {
				map.remove(s1c);
			} else {
				map.put(s1c, s1Val + 1);
			}
			char s2c = s2.charAt(i);
			Integer s2Val = map.getOrDefault(s2c, 0);
			if (s2Val - 1 == 0) {
				map.remove(s2c);
			} else {
				map.put(s2c, s2Val - 1);
			}
		}
		if (map.size() == 0) {
			return true;
		}

		int left = 0;
		for (int i = s1.length(); i < s2.length(); i++) {
			char s2lc = s2.charAt(left);
			Integer preVal = map.getOrDefault(s2lc, 0);
			if (preVal + 1 == 0) {
				map.remove(s2lc);
			} else {
				map.put(s2lc, preVal + 1);
			}
			left++;
			char c = s2.charAt(i);
			Integer val = map.getOrDefault(c, 0);
			if (--val == 0) {
				map.remove(c);
			} else {
				map.put(c, val);
			}
			if (map.size() == 0) {
				return true;
			}
		}
		return false;
	}
}
