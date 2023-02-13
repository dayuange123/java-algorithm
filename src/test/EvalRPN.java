package test;

import java.util.LinkedList;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/30
 * Description:
 */
public class EvalRPN {
	public static void main(String[] args) {
		new EvalRPN().evalRPN(new String[]{"4", "13", "5", "/", "+"});
	}

	public int evalRPN(String[] tokens) {


		LinkedList<Integer> linkedList = new LinkedList<>();

		for (String token : tokens) {

			if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				Integer pop1 = linkedList.pollLast();
				Integer pop2 = linkedList.pollLast();
				Integer after;
				switch (token) {
					case "+":
						after = pop1 + pop2;
						break;
					case "-":
						after = pop2 - pop1;
						break;
					case "*":
						after = pop1 * pop2;
						break;
					default:
						after = pop2 / pop1;
						break;
				}
				linkedList.addLast(after);

				System.out.println(after);
			} else {
				linkedList.addLast(Integer.parseInt(token));
			}
		}
		return linkedList.pop();
	}
}
