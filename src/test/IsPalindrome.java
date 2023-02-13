package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/23
 * Description:
 */
public class IsPalindrome {

	public boolean isPalindrome(String s) {

		int left = 0;
		int right = s.length() - 1;

		s = s.toUpperCase();
		while (left < right) {
			char cl = s.charAt(left);
			char cr = s.charAt(right);
			if (!((cl >= 'A' && cl <= 'Z') || (cl >= '0' && cl <= '9'))) {
				left++;
				continue;
			}
			if (!((cr >= 'A' && cr <= 'Z') || (cr >= '0' && cr <= '9'))) {
				right--;
				continue;
			}
			if (cl == cr) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}


}
