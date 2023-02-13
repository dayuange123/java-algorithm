package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/25
 * Description:
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


		ListNode l1r = reverseList(l1);
		ListNode l2r = reverseList(l2);
		ListNode resHead = null;
		ListNode tmp = null;

		boolean flag = false;
		while (l1r != null || l2r != null) {
			if (resHead == null) {
				int val = l1r.val + l2r.val;
				flag = val / 10 > 0;
				resHead = new ListNode(val % 10);
				tmp = resHead;
				l2r = l2r.next;
				l1r = l1r.next;
			} else {



				if (l1r == null) {
					int val = l2r.val + (flag ? 1 : 0);

					flag = val / 10 > 0;
					tmp.next = new ListNode(val % 10);
					l2r = l2r.next;

				} else if (l2r == null) {
					int val = l1r.val + (flag ? 1 : 0);
					flag = val / 10 > 0;
					tmp.next = new ListNode(val % 10);
					l1r = l1r.next;

				} else {
					int val = l1r.val + l2r.val + (flag ? 1 : 0);

					flag = val / 10 > 0;
					tmp.next = new ListNode(val % 10);
					l2r = l2r.next;
					l1r = l1r.next;
				}
				tmp = tmp.next;

			}
		}
		if (flag){
			tmp.next=new ListNode(1);
		}
		return reverseList(resHead);

	}

	private ListNode reverseList(ListNode head) {

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
