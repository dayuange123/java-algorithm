package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/24
 * Description:
 */
public class DetectCycle {
	/**
	 * 给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回 null。
	 * <p>
	 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
	 * <p>
	 * 说明：不允许修改给定的链表。
	 * <p>
	 *  
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/c32eOV
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {

		ListNode fast = head;
		ListNode slow = head;
		while (fast != null) {
			if (fast.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
			if (fast == head) {
				ListNode ptr = head;
				while (ptr != slow) {
					ptr = ptr.next;
					slow = slow.next;
				}
				return ptr;
			}
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
