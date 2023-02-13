package test;

import java.util.Arrays;

public class SequenceReconstruction {

	/**
	 * 序列重建
	 *
	 * @param nums      全国矿工工会
	 * @param sequences 序列
	 * @return boolean
	 * @author liuzhiyuan
	 */
	public boolean sequenceReconstruction(int[] nums, int[][] sequences) {

		int[] minSequence = sequences[0];


		//解题思路 找到sequences的最短子序列。
		for (int i = 1; i < sequences.length; i++) {

			int[] sequence = sequences[i];

		}


		return Arrays.equals(nums,minSequence);
	}


}
