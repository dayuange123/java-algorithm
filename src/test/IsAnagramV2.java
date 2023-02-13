package test;

import java.util.Arrays;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/28
 * Description:
 */
public class IsAnagramV2 {

	/**
	 * 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
	 * <p>
	 * 注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。
	 * <p>
	 *  
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: s = "anagram", t = "nagaram"
	 * 输出: true
	 * 示例 2:
	 * <p>
	 * 输入: s = "rat", t = "car"
	 * 输出: false
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/dKk3P7
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram(String s, String t) {
		if (s.equals(t) || s.length() != t.length()) {
			return false;
		}
		int[] array = new int[26];
		for (int i = 0; i < s.length(); ++i) {
			array[s.charAt(i) - 'a']++;
			array[t.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; ++i) {
			if (array[i]!=0){
				return false;
			}

		}
		return true;
	}
}
