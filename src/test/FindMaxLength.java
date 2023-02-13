package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/21
 * Description:
 */
public class FindMaxLength {

	/**
	 * 输入: nums = [0,1,0]
	 * 输出: 2
	 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
	 *
	 * @param nums
	 * @return
	 */
	public int findMaxLength(int[] nums) {


		Map<Integer, Integer> recordMap = new HashMap<>();
		int max = 0;
		recordMap.put(0, -1);
		int counter = 0;
		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == 0) {
				counter--;
			} else {
				counter++;
			}
			if (recordMap.containsKey(counter)) {
				Integer index = recordMap.get(counter);
				max = Math.max(max, i - index);
			} else {
				recordMap.put(counter, i);
			}
		}
		return max;

	}
}
