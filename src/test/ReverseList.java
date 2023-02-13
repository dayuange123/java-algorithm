package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/25
 * Description:
 */
public class ReverseList {
	public ListNode reverseList(ListNode head) {

		ListNode preHead = new ListNode(1);

		while (head != null) {
			ListNode next = preHead.next;
			ListNode headNext = head.next;

			preHead.next = head;
			head.next = next;

			// 1 2 3
			head = headNext;
		}

		return preHead.next;
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
