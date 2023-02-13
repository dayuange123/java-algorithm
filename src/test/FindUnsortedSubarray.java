package test;

import java.util.LinkedList;

public class FindUnsortedSubarray {

	public static void main(String[] args) {

		new FindUnsortedSubarray().findUnsortedSubarray1(new int[]{2, 6, 4, 8, 10, 9, 15});
	}

	public int findUnsortedSubarray1(int[] nums) {
		int left = 0;
		boolean flag = true;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[left]) {
				i--;
				left--;
				flag = false;
			}
			if (left == -1) {
				break;
			}
			if (flag) {
				left++;
			}
		}
		int right = nums.length - 1;
		flag = true;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] > nums[right]) {
				i++;
				right++;
				flag = false;

			}
			if (right == nums.length) {
				break;
			}
			if (flag) {
				right--;
			}
		}
		return Math.max(right - left - 1, 0);
	}

	public int findUnsortedSubarray(int[] nums) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.addLast(nums[0]);
		boolean f = true;
		for (int i = 1; i < nums.length; i++) {

			if (linkedList.isEmpty()) {
				break;
			}
			if (linkedList.getLast() > nums[i]) {
				i--;
				linkedList.removeLast();
				f = false;
			}
			if (f) {
				linkedList.addLast(nums[i]);
			}
		}
		int left = linkedList.size();
		linkedList.clear();
		f = true;
		linkedList.addLast(nums[nums.length - 1]);
		for (int i = nums.length - 2; i >= 0; i--) {
			if (linkedList.isEmpty()) {
				break;
			}
			if (linkedList.getLast() < nums[i]) {
				linkedList.removeLast();
				i++;
				f = false;
			}
			if (f) {
				linkedList.addLast(nums[i]);
			}
		}
		int right = nums.length - linkedList.size();

		return Math.max(right - left, 0);
	}
	//[2,6,4,8,10,9,15]
}
