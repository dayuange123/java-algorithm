package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/21
 * Description:
 */
public class MinSubArrayLen {

	public int minSubArrayLen(int target, int[] nums) {

		int left = 0;
		int sum = 0;
		int result = nums.length + 1;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum >= target) {
				result = Math.min(result, i - left + 1);
				sum -= nums[left++];
				i--;
			}
		}
		return result == nums.length + 1 ? 0 : result;
	}
}
