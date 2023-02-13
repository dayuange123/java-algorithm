package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/28
 * Description:
 */
public class Node {
	public int val;
	public Node next;
	public Node prev;

	public Node child;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _next) {
		val = _val;
		next = _next;
	}
}
