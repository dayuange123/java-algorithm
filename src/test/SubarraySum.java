package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: liuzhiyuan
 * Date: 2022/2/24
 * Description:
 */
public class SubarraySum {

	public static void main(String[] args) {
		System.out.println(new SubarraySum().subarraySum(new int[]{1, 1, 1}, 2));
	}

	/**
	 * 示例 1：
	 * <p>
	 * 输入：nums = [1,1,1], k = 2
	 * 输出：2
	 * 示例 2：
	 * <p>
	 * 输入：nums = [1,2,3], k = 3
	 * 输出：2
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum(int[] nums, int k) {

		/**
		 *
		 * i，j i,j-1+nums[j]
		 * 00 01  02 03 04
		 * 11 12 13
		 *
		 */
		int[][] dp = new int[nums.length][nums.length];
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			dp[i][i] = nums[i];

			if (nums[i] == k) {
				ans++;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				dp[i][j] = dp[i][j - 1] + nums[j];
				if (dp[i][j] == k) {
					ans++;
				}
			}
		}
		return ans;
	}

	public int subarraySumV2(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();
		int result = 0;
		int counter = 0;
		map.put(0, 1);
		for (int num : nums) {
			counter += num;
			result += map.getOrDefault(counter - k, 0);
			Integer counterSize = map.get(counter);
			if (counterSize == null) {
				map.put(counter, 1);
			} else {
				map.put(counter, ++counterSize);
			}
		}
		return result;
	}
}
