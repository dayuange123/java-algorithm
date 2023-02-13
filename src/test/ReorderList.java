package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/25
 * Description:
 */
public class ReorderList {
	/**
	 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
	 * <p>
	 *  L0 → L1 → … → Ln-1 → Ln 
	 * 请将其重新排列后变为：
	 * <p>
	 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
	 * <p>
	 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
	 * <p>
	 * 输入: head = [1,5,2,3,4,5]
	 * 输出: [1,5,2,4,3]
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/LGjMqU
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param head
	 */
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		test(head.next, head);
	}


	public ListNode test(ListNode node, ListNode head) {
		if (node.next == null) {
			ListNode next = head.next;
			if (node == next) {
				return null;
			}
			head.next = node;
			node.next = next;
			return next;
		}
		ListNode test = test(node.next, head);
		if (test == null) {
			return null;
		}

		if (node == test) {
			node.next = null;
			return null;
		}
		ListNode next = test.next;
		if (next == node) {
			node.next = null;
			return null;
		}

		test.next=node;
		node.next=next;
		return next;
		// 1 ,2 ,3 ,4  . 1 4 2 3
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
