package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/17
 * Description:
 */
public class MaxProduct {
	public static void main(String[] args) {

		int i = new MaxProduct().maxProduct(new String[]{"abcw", "baz", "foo", "bar", "fxyz", "abcdef"});
		System.out.println(i);
	}

	public int maxProduct(String[] words) {

		int[] array = new int[words.length];
		for (int i = 0; i < words.length; i++) {

			for (int j = 0; j < words[i].length(); j++) {


				array[i] = array[i] | (1 << (words[i].charAt(j) - 'a'));

			}
		}
		int result = 0;

		for (int i = 0; i < words.length; i++) {

			for (int j = i + 1; j < words.length; j++) {

				if ((array[i] & array[j]) == 0) {
					result = Math.max(result, words[i].length() * words[j].length());
				}
			}
		}
		return result;
	}
}
