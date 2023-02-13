package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/24
 * Description:
 */


public class GetIntersectionNode {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null) {
			return null;
		}

		ListNode t1 = headA;
		ListNode t2 = headB;

		boolean swap = false;
		while (!(t1 == null && t2 == null && swap)) {
			if (t1 == null) {
				swap = true;
				t1 = headB;
			}
			if (t2 == null) {
				t2 = headA;
			}
			if (t1 == t2) {
				return t1;
			}
			t1 = t1.next;
			t2 = t2.next;
		}
		return null;
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
