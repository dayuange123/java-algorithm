package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/25
 * Description:
 */
public class InsertNode {
	public Node insert(Node head, int insertVal) {
		if (head == null) {
			Node node = new Node(insertVal);
			node.next = node;
			return node;
		}

		Node tmp = head;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		while (true) {
			max = Math.max(tmp.val, max);
			min = Math.min(tmp.val, min);
			if (tmp.val <= insertVal && tmp.next.val >= insertVal) {
				tmp.next = new Node(insertVal, tmp.next);
				break;
			}
			tmp = tmp.next;
			//1 0
			if (tmp == head) {
				//最大或者最小
				while (true) {
					if (insertVal < min && tmp.val == max) {
						tmp.next = new Node(insertVal, tmp.next);
						break;
					}

					if (insertVal > max && tmp.next.val == min) {
						tmp.next = new Node(insertVal, tmp.next);
						break;
					}
					tmp = tmp.next;
				}
				break;
			}
		}
		return head;
	}


}
