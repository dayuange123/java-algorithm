package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/16
 * Description:
 */
public class CountBits {

	//dp
	public int[] countBits(int n) {

		int[] result = new int[n];

		for (int i = 1; i < n; i++) {

			result[i] = result[i / 2] + i & 1;
		}

		return result;
	}
}
