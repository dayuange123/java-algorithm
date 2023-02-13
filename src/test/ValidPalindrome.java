package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/23
 * Description:
 */
public class ValidPalindrome {


	public boolean validPalindrome(String s) {


		String reverse = new StringBuffer(s).reverse().toString();
		if (reverse.equals(s)) {
			return true;
		}

		int left = 0;
		int right = s.length() - 1;
		while (left < right) {

			if (s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
				continue;
			}

			String substring = s.substring(left, right);
			String substring1 = s.substring(left + 1, right + 1);
			return new StringBuffer(substring).reverse().toString().equals(substring)
					|| new StringBuffer(substring1).reverse().toString().equals(substring1);
		}

		return false;

	}


}
