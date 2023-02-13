package test;

import java.util.Stack;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/30
 * Description:
 */
public class DailyTemperatures {

	/**
	 * 单调栈
	 *
	 * @param temperatures
	 * @return
	 */
	public int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[temperatures.length];

		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
				Integer pop = stack.pop();
				result[pop] = i - pop;
			}
			stack.push(i);
		}
		return result;
	}

}
