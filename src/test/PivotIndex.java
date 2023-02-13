package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/21
 * Description:
 */
public class PivotIndex {

	public int pivotIndex(int[] nums) {


		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum==0){
			return 0;
		}

		int currentSum = 0;
		for (int i = 0; i < nums.length; i++) {
			int gap = sum - nums[i];

			if (gap == currentSum * 2) {
				return i+1;
			}
			currentSum += nums[i];
		}
		return -1;
	}


}
