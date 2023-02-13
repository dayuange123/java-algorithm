package test;

import java.util.Arrays;
import java.util.List;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/29
 * Description:
 */
public class FindMinDifference {

	public static void main(String[] args) {
		System.out.println(Integer.parseInt("00"));
	}

	/**
	 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
	 * <p>
	 *  
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：timePoints = ["23:59","00:00"]
	 * 输出：1
	 * 示例 2：
	 * <p>
	 * 输入：timePoints = ["00:00","23:59","00:00"]
	 * 输出：0
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/569nqc
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param timePoints
	 * @return
	 */
	public int findMinDifference(List<String> timePoints) {

		int[] array = new int[timePoints.size()];
		for (int i = 0; i < timePoints.size(); i++) {
			String s = timePoints.get(i);
			String[] split = s.split(":");

			array[i] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
		}
		Arrays.sort(array);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {

			if (i + 1 == array.length) {
				min = Math.min(array[0] + 24 * 60 - array[i], min);
			} else {
				min = Math.min(array[i + 1] - array[i], min);
			}
		}
		return min;

	}
}
