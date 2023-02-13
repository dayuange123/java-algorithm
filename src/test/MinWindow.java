package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/23
 * Description:
 */
public class MinWindow {

	public static void main(String[] args) {
		String s = new MinWindow().minWindow("ADOBECODEBANC", "ABC");
		System.out.println(s);
	}

	/**
	 * 给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
	 * <p>
	 * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
	 * <p>
	 *  
	 * <p>
	 * 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
	 * <p>
	 *  
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：s = "ADOBECODEBANC", t = "ABC"
	 * 输出："BANC"
	 * 解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C'
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/M1oyTv
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param s
	 * @param t
	 * @return
	 */
	public String minWindow(String s, String t) {
		if (t.length() > s.length()) {
			return "";
		}
		if (s.contains(t)) {
			return t;
		}
		Map<Character, Integer> tCMap = new HashMap<>();
		Map<Character, Integer> set = new HashMap();
		for (int i = 0; i < t.length(); i++) {
			set.put(t.charAt(i), set.getOrDefault(t.charAt(i), 0) + 1);
		}
		int left = 0;
		int cl = 0;
		int cr = s.length() + 1;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			tCMap.put(c, tCMap.getOrDefault(c, 0) + 1);
			if (comp(tCMap, set)) {
				while (!set.containsKey(s.charAt(left)) || tCMap.getOrDefault(s.charAt(left), 0) >= set.get(s.charAt(left))) {
					if (i - left < cr - cl) {
						cl = left;
						cr = i;
					}
					int integer = tCMap.getOrDefault(s.charAt(left), 0);
					if (!set.containsKey(s.charAt(left))) {
						left++;
						continue;
					}
					if (integer - 1 == 0) {
						tCMap.remove(s.charAt(left));
					} else {
						tCMap.put(s.charAt(left), integer - 1);
					}
					left++;
					if (integer - 1 < set.get(s.charAt(left - 1))) {
						break;
					}
				}
			}

		}
		return cr - cl == s.length() + 1 ? "" : s.substring(cl, cr + 1);
	}

	public boolean comp(Map<Character, Integer> tCMap, Map<Character, Integer> setMap) {
		if (tCMap.size() < setMap.size()) {
			return false;
		}
		for (Character character : setMap.keySet()) {
			if (tCMap.getOrDefault(character, 0) < setMap.get(character)) {
				return false;
			}
		}
		return true;

	}


	public String minWindow1(String s, String t) {
		//A~z 对应ASCII 65 ~ 122;   122 - 65 + 1 = 58，所以开辟60足够用了。
		int[] count1 = new int[60];
		int[] count2 = new int[60];
		int n1 = s.length();
		int n2 = t.length();
		//维护一个最小长度，用于判断是否更新ans
		int minLength = s.length();
		String ans = "";
		//特判，s短于t,直接返回""
		if (n1 < n2) {
			return ans;
		}
		//统计出t中的词频
		for (char c : t.toCharArray()) {
			count2[c - 'A']++;
		}
		//滑动窗口的起始位置分别为 i 、 j;
		int i = 0;//起始位置
		for (int j = 0; j < n1; j++) {
			//j对应字符进入窗口
			count1[s.charAt(j) - 'A']++;
			//如果当前的窗口已经包含了t中所有词频，则不断缩小窗口左边界
			while (Cover(count1, count2)) {
				//取等于号是WA出来的，对应样例 s = "a", t = "s";
				if (j - i + 1 <= minLength) {
					minLength = j - i + 1;
					ans = s.substring(i, i + minLength);
				}
				//左边界缩小，左边界对应的字符出窗
				count1[s.charAt(i) - 'A']--;
				i++;
			}
		}
		return ans;
	}

	//判断count1是否每一个元素都大于count2；
	boolean Cover(int[] count1, int[] count2) {
		for (int i = 0; i < 60; i++) {
			if (count1[i] < count2[i]) {
				return false;
			}
		}
		return true;
	}


}
