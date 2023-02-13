package test;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/25
 * Description:
 */
public class IsPalindromeNode {

	private ListNode frontPointer;

	private boolean recursivelyCheck(ListNode currentNode) {
		if (currentNode != null) {
			if (!recursivelyCheck(currentNode.next)) {
				return false;
			}
			if (currentNode.val != frontPointer.val) {
				return false;
			}
			frontPointer = frontPointer.next;
		}
		return true;
	}

	public boolean isPalindromeV2(ListNode head) {
		frontPointer = head;
		return recursivelyCheck(head);
	}




	public boolean isPalindrome(ListNode head) {
		if (head.next == null) {
			return true;
		}
		AtomicBoolean res = new AtomicBoolean(false);
		isPalindrome(head, head, res);
		return res.get();
	}

	private ListNode isPalindrome(ListNode node, ListNode head, AtomicBoolean res) {
		if (node.next == null) {
			if (node.val != head.val) {
				return null;
			}
			if (head.next == node) {
				res.set(true);
				return null;
			}
			return head.next;
		}
		ListNode palindrome = isPalindrome(node.next, head, res);
		if (palindrome == null) {
			return null;
		}
		if (palindrome == node || palindrome.next == node) {
			res.set(palindrome.val == node.val);
			return null;
		}
		return palindrome.next;
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
