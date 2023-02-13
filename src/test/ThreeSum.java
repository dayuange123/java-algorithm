package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/21
 * Description:
 */
public class ThreeSum {


	public static void main(String[] args) {
		List<List<Integer>> lists = new ThreeSum().threeSum(new int[]{0, 1, -1, -1, -1, 0, 1, 2});

		System.out.println(lists);
	}

	/**
	 * 输入：nums = [-1,0,1,2,-1,-4]
	 * -4 -1 -1 0 1 2
	 * 输出：[[-1,-1,2],[-1,0,1]]
	 *
	 * @param nums
	 * @return
	 */

	public List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int cur = nums[i];
			if (i > 0 && cur == nums[i - 1]) {
				continue;
			}
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {

				if (left > i + 1 && nums[left] == nums[left - 1]) {
					left++;
					continue;
				}
				if (right < nums.length - 1 && nums[right] == nums[right +1]) {
					right--;
					continue;
				}

				int i1 = nums[left] + nums[right];
				if (i1 + cur == 0) {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(cur);
					list.add(nums[left]);
					list.add(nums[right]);
					result.add(list);
					left++;
					right--;

				} else if (i1 + cur > 0) {
					right--;
				} else {
					left++;
				}
			}
			//双指针
		}
		return result;
	}
}
