package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/24
 * Description:
 */
public class RemoveNthFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode headPre = new ListNode(0);
		headPre.next = head;
		ListNode l = headPre;
		ListNode r = headPre;

		for (int i = 0; i < n; i++) {
			r = r.next;
		}
		while (r != null) {
			if (r.next == null) {
				l.next = l.next.next;
			} else {
				l = l.next;
				r = r.next;
			}

		}
		return headPre.next;

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
