package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/21
 * Description:
 */
public class NumSubarrayProductLessThanK {

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		//1 ,2 ,3  0
		int left = 0;
		int sum = 1;
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= k) {
				continue;
			}
			int i1 = sum * nums[i];
			if (i1 < k) {
				result += i - left + 1;
				sum = i1;
			} else {
				sum /= nums[left++];
				i--;
			}
		}
		return result;
	}
}
